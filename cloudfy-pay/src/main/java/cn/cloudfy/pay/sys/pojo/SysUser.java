package cn.cloudfy.pay.sys.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Description: 系统用户表
 */
@Data
@Table(name = "sys_user")
public class SysUser {
	/**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 用户名
     */
	private String name;
	/**
     * 年龄
     */
	private Integer age;
	/**
     * 地址
     */
	private String address;
	
	
}
