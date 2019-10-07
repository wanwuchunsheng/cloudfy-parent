package cn.cloudfy.chart.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import cn.cloudfy.common.dto.LogDTO;
import lombok.Data;

/**
 * @Date: 2018/12/18 15:41
 * @Description: 日志
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@Table(name = "sys_log")
public class Log extends LogDTO {


    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

}
