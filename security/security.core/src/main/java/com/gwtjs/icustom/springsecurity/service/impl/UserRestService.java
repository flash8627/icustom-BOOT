package com.gwtjs.icustom.springsecurity.service.impl;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.springsecurity.dao.ISysUserDao;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;
import com.gwtjs.icustom.springsecurity.service.IUserRestService;

@Api("/user")
public class UserRestService implements IUserRestService {
	

	@Autowired
	private ISysUserDao userDao;
	
	/**
	 * 用户登陆会用到
	 */
	public SysUserVO findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	/**
	 * 用户登陆会用到
	 */
	public SysUserVO findByAccount(String account) {
		return userDao.findByAccount(account);
	}
	
	@Override
	public int saveOrUpdate(List<SysUserVO> userList) {
		return userDao.saveOrUpdate(userList);
	}

}
