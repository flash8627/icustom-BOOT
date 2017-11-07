package com.gwtjs.icustom.springsecurity.service.impl;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.springsecurity.dao.ISysResourceDao;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;
import com.gwtjs.icustom.springsecurity.service.IResourceRestService;

@Api("/resource") @Service("resourceRestService")
public class ResourceRestService implements IResourceRestService {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Override
	public int saveOrUpdate(List<SysResourceVO> sys) {
		// TODO Auto-generated method stub
		return sysResourceDao.saveOrUpdate(sys);
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
