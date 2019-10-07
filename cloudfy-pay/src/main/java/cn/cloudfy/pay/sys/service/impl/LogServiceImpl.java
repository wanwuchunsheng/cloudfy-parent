package cn.cloudfy.pay.sys.service.impl;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.cloudfy.common.constant.Constants;
import cn.cloudfy.common.dto.LogDTO;
import cn.cloudfy.common.dto.QueryPojo;
import cn.cloudfy.common.pojo.Page;
import cn.cloudfy.common.pojo.Result;
import cn.cloudfy.pay.sys.dao.LogDao;
import cn.cloudfy.pay.sys.pojo.Log;
import cn.cloudfy.pay.sys.service.LogService;
import tk.mybatis.mapper.entity.Example;

/**
 * @Date: 2018/12/18 15:44
 * @Description: 日志业务层实现
 */
@Service
public class LogServiceImpl implements LogService {


    @Autowired
    private LogDao logDao;


    /**
     * 保存日志
     * @param logDTOList
     * @return
     */
    @Transactional
    @Override
    public Integer saveLog(List<LogDTO> logDTOList) {
        return this.logDao.saveLog(logDTOList);
    }


    /**
     * 分页查询日志
     * @param page
     * @param queryPojo
     * @return
     */
    @Override
    public Result selectLogByPage(Page page, QueryPojo queryPojo) {
        com.github.pagehelper.Page<Object> objectPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Example example = new Example(Log.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(queryPojo.getOrderNo())) {
            criteria.orLike("logUser", Constants.PER_CENT + queryPojo.getName() + Constants.PER_CENT);
        }
        if (queryPojo.getStartTime() != null && queryPojo.getEndTime() != null) {
            criteria.orBetween("oprationTime", queryPojo.getStartTime(), queryPojo.getEndTime());
        }
        List<Log> logs = this.logDao.selectByExample(example);
        return Result.data(objectPage.getTotal(), logs);
    }
}
