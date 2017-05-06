package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.springsecurity.entity.SysUser;
import com.gwtjs.springsecurity.jaxrs.dao.ISysUserDao;
import com.gwtjs.springsecurity.jaxrs.service.IUserRestService;

@Api("/user")
public class UserRestService implements IUserRestService {

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
