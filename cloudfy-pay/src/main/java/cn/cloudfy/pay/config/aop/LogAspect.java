package cn.cloudfy.pay.config.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.cloudfy.common.aop.AopAround;
import cn.cloudfy.common.dto.LogDTO;
import cn.cloudfy.common.queue.LogQueue;
import cn.cloudfy.pay.sys.service.LogService;


/**
 * 日志AOP
 */
@Aspect
@Component
@Order(3)
public class LogAspect {


    @Autowired
    private LogService logService;


    /**
     * 切点
     *
     * @return
     */
    @Pointcut("execution(* cn.cloudfy.pay.*.controller.*.*.*(..)) && @annotation(cn.cloudfy.common.annotation.TraceLog)")
    public void webLog() {
    }


    /**
     * 后置返回通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @AfterReturning(pointcut = "webLog()", returning = "retValue")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object retValue) {
        AopAround.setLogQueue(joinPoint, retValue);
    }


    /**
     * 后置最终通知
     */
    @After("webLog()")
    public void doAfterAdvice(){
        // 判断队列是有数据。大于100，批量插入数据库
        Queue<LogDTO> queue = LogQueue.getQueue();
        if (queue.size() >= 2) {
            int size = queue.size();
            List<LogDTO> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(queue.poll());
            }
            this.logService.saveLog(list);
        }
    }

}