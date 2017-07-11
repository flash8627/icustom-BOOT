package com.gwtjs.icustom.springsecurity.api.impl;

import io.swagger.annotations.Api;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.icustom.springsecurity.api.IResourceService;
import com.gwtjs.icustom.springsecurity.dao.ISysResourceDao;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

@Named
public class ResourceService implements IResourceService {

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

