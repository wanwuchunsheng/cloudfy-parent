package cn.cloudfy.pay.sys.service;

import cn.cloudfy.common.pojo.Page;
import cn.cloudfy.common.pojo.Result;
import cn.cloudfy.pay.sys.pojo.SysUser;

/**
 * @Description: 系统业务层接口
 */
public interface SysUserService {

	/**
     * 分页查询用户
     *
     * @param page
     * @return
     */
	Result selectSysUserByPage(Page page, SysUser sysUser);

	/**
     * 添加用户
     *
     * @return
     */
	void saveSysUser(SysUser sysUser);

    
}