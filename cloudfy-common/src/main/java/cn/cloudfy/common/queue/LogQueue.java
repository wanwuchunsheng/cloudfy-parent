package cn.cloudfy.common.queue;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.http.HttpServletRequest;

import cn.cloudfy.common.dto.LogDTO;
import cn.cloudfy.common.pojo.User;
import cn.cloudfy.common.thread.UserThreadLocal;
import cn.cloudfy.common.utils.CommonUtils;

/**
 * @Date: 2018/12/18 14:39
 * @Description: 日志队列
 */
public class LogQueue {


    private static Queue<LogDTO> queue = new LinkedBlockingDeque<>();


    public static Queue<LogDTO> getQueue() {
        return queue;
    }


    public static void setQueue(HttpServletRequest request, String logContent, String logJson, int result) {
        String uri = request.getRequestURI();
        LogDTO logDTO = new LogDTO();
        logDTO.setLogUrl(uri);
        logDTO.setLogContent(logContent);
        logDTO.setLogJson(logJson);
        logDTO.setOprationTime(new Date());
        logDTO.setIpAddress(CommonUtils.getIpAddress(request));
        logDTO.setResult(result);
        User user = UserThreadLocal.getUser();
        if (user != null) {
            logDTO.setLogUser(user.getUsername());
        }
        queue.add(logDTO);
    }

}
