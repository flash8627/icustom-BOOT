package com.gwtjs.icustom.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysResourceDao;
import com.gwtjs.icustom.springsecurity.jaxrs.service.IResourceRestService;

@Api("/resource")
public class ResourceRestService implements IResourceRestService {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Override
	public int insert(SysResourceVO sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.insert(sys);
	}

	@Override
	public int update(SysResourceVO sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.update(sys);
	}

	@Override
	public int delete(SysResourceVO role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysResourceVO> findAll() {
		// TODO Auto-generated method stub
		return sysResourceDao.findAll();
	}

}
