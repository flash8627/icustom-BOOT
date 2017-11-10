package com.gwtjs.icustom.security.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.icustom.security.dao.ISysResourcesDAO;
import com.gwtjs.icustom.security.entity.SysResourcesVO;
import com.gwtjs.icustom.security.services.IAuthoritiesResourcesTreeService;

@Named("authoritiesResourcesTreeService")
public class AuthoritiesResourcesTreeService implements IAuthoritiesResourcesTreeService {
	
	@Inject
	private ISysResourcesDAO resourcesDAO;
	
	@Override
	public List<SysResourcesVO> findAuthResourcesTreeRoot() {
		List<SysResourcesVO> records = resourcesDAO.findAuthResourcesTreeRoot();
		return records;
	}
	
	@Override
	public List<SysResourcesVO> findAuthResourcesTree(SysResourcesVO auth) {
		List<SysResourcesVO> records = resourcesDAO.findAuthResourcesTree(auth);
		return records;
	}
	
}
