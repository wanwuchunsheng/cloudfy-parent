package cn.cloudfy.pay.sys.service;

import java.util.List;

import cn.cloudfy.common.dto.LogDTO;
import cn.cloudfy.common.dto.QueryPojo;
import cn.cloudfy.common.pojo.Page;
import cn.cloudfy.common.pojo.Result;

/**
 * @Date: 2018/12/18 15:43
 * @Description: 日志业务层接口
 */
public interface LogService {


    /**
     * 保存日志
     * @param logDTOList
     * @return
     */
    Integer saveLog(List<LogDTO> logDTOList);


    /**
     * 分页查询日志
     * @param page
     * @param queryPojo
     * @return
     */
    Result selectLogByPage(Page page, QueryPojo queryPojo);
}
