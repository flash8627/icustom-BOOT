package com.gwtjs.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwtjs.springsecurity.dao.UserDao;
import com.gwtjs.springsecurity.model.SysUserVO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public SysUserVO findById(int id) {
		return dao.findById(id);
	}

	public SysUserVO findBySso(String sso) {
		return dao.findBySSO(sso);
	}

}
