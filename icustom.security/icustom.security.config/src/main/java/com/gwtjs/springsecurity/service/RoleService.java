package com.gwtjs.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtjs.springsecurity.dao.SysRoleDao;

@Service("roleService")
public class RoleService {
	
	@Autowired
	private SysRoleDao roleDao;
	
}
