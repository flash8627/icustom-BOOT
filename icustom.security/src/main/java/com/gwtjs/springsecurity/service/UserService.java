package com.gwtjs.springsecurity.service;

import com.gwtjs.springsecurity.model.SysUserVO;

public interface UserService {

	SysUserVO findById(int id);
	
	SysUserVO findBySso(String sso);
	
}