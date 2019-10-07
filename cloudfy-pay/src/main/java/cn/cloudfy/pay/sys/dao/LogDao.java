package cn.cloudfy.pay.sys.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.cloudfy.common.dto.LogDTO;
import cn.cloudfy.pay.sys.pojo.Log;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Date: 2018/12/18 15:42
 * @Description: 日志持久层接口
 */
@Repository
public interface LogDao extends Mapper<Log> {


    /**
     * 保存日志
     * @param logDTOList
     * @return
     */
    Integer saveLog(@Param("saveLog") List<LogDTO> logDTOList);
}
