package com.gwtjs.springsecurity.dao;

import com.gwtjs.springsecurity.model.SysUserVO;

public interface UserDao {

	SysUserVO findById(int id);
	
	SysUserVO findBySSO(String sso);
	
}

