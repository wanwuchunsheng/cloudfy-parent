package cn.cloudfy.pay.sys.dao;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

import cn.cloudfy.pay.sys.pojo.SysUser;


/**
 * @Date: 2019/1/16 19:45
 * @Description: 系统管理持久层接口
 */
@Repository
public interface SysUserDao extends Mapper<SysUser> {
}
