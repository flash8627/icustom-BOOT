package com.gwtjs.icustom.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.springsecurity.entity.SysUser;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysUserDao;
import com.gwtjs.icustom.springsecurity.jaxrs.service.IUserRestService;

@Api("/user")
public class UserRestService implements IUserRestService {
	
	public SysUser findByName(String account) {
		return null;
	}
	
	@Autowired
	private ISysUserDao userDao;

	@Override
	public List<SysUser> findAllUserList() {
		return userDao.findAllUserList();
	}

	@Override
	public int insert(List<SysUser> userList) {
		return userDao.batchInsert(userList);
	}

}
