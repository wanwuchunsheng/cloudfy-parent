package cn.cloudfy.pay.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

import cn.cloudfy.common.constant.Constants;
import cn.cloudfy.common.pojo.Page;
import cn.cloudfy.common.pojo.Result;
import cn.cloudfy.pay.sys.dao.SysUserDao;
import cn.cloudfy.pay.sys.pojo.SysUser;
import cn.cloudfy.pay.sys.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * @Description: 系统业务层实现
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	/**
     * 分页查询用户
     *
     * @param page
     * @return
     */
	@Override
	public Result selectSysUserByPage(Page page, SysUser sysUser) {
		com.github.pagehelper.Page<Object> objectPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
		Example example = new Example(SysUser.class);
        example.setOrderByClause("id desc");
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(sysUser.getName())) {
            criteria.andLike("name", Constants.PER_CENT + sysUser.getName() + Constants.PER_CENT);
        }
		List<SysUser> list=this.sysUserDao.selectByExample(example);
		return Result.data(objectPage.getTotal(), list);
	}

	/**
     * 添加用户
     *
     * @return
     */
	@Transactional
	@Override
	public void saveSysUser(SysUser sysUser) {
		this.sysUserDao.insertSelective(sysUser);
		log.info("插入成功，返回值:{}",sysUser.getId());
	}
}
