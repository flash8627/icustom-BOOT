package com.gwtjs.springsecurity.jaxrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gwtjs.springsecurity.entity.SysResource;
import com.gwtjs.springsecurity.jaxrs.dao.ISysResourceDao;
import com.gwtjs.springsecurity.jaxrs.service.IResourceRestService;

@Controller
public class ResourceRestService implements IResourceRestService {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Override
	public int insert(SysResource sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.insert(sys);
	}

	@Override
	public int update(SysResource sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.update(sys);
	}

	@Override
	public int delete(SysResource role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysResource> findAll() {
		// TODO Auto-generated method stub
		return sysResourceDao.findAll();
	}

}
