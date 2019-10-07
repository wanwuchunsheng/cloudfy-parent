package cn.cloudfy.chart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cloudfy.chart.dao.LogDao;
import cn.cloudfy.chart.service.LogService;
import cn.cloudfy.common.dto.LogDTO;

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
    

}
