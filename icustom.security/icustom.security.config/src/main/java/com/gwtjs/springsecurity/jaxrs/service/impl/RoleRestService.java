package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.springsecurity.entity.SysRole;
import com.gwtjs.springsecurity.jaxrs.dao.ISysRoleDao;
import com.gwtjs.springsecurity.jaxrs.service.IRoleRestService;

@Api("/role")
public class RoleRestService implements IRoleRestService {

	@Autowired
	private ISysRoleDao sysRoleDao;

	@Override
	public int insert(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleDao.insert(role);
	}

	@Override
	public int delete(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleDao.delete(role);
	}

	@Override
	public int update(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleDao.update(role);
	}

	@Override
	public PagedResult<SysRole> findRolePage(SysRole role,PageVO page) {
		System.out.println("role:\n"+role);
		System.out.println("page:\n"+page);
		// TODO Auto-generated method stub
		return sysRoleDao.findRolePage(role, page);
	}

}
