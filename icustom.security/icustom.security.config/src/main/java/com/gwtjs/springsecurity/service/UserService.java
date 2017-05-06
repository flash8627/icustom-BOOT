package com.gwtjs.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtjs.springsecurity.dao.SysUserDao;
import com.gwtjs.springsecurity.entity.SysUser;

@Service("userService")
public class UserService {

	@Autowired
	private SysUserDao sysUserDao;

	public SysUser findByName(String account) {
		return sysUserDao.findByName(account);
	}

	public int update(SysUser user) {
		return sysUserDao.update(user.getUsername(), user.getEmail(),
				user.getPassword(), user.getId());
	}

}
