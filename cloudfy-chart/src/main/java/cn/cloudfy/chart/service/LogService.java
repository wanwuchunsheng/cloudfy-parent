package cn.cloudfy.chart.service;

import java.util.List;

import cn.cloudfy.common.dto.LogDTO;

public interface LogService {

	/**
     * 保存日志
     * @param logDTOList
     * @return
     */
    Integer saveLog(List<LogDTO> logDTOList);
    
    
}
