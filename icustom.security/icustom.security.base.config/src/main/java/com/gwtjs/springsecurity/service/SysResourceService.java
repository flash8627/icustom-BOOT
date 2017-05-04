package com.gwtjs.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtjs.springsecurity.dao.SysResourceDao;
import com.gwtjs.springsecurity.entity.SysResource;

@Service("resourceService")
public class SysResourceService {
	
	@Autowired
	private SysResourceDao sysResourceDao;
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public List<SysResource> findByResourceString(String url){
		List<SysResource> list = new ArrayList<>();
		list = sysResourceDao.findByResourceString(url);
		return list;
	}
	
	public SysResource save(SysResource resource){
		return sysResourceDao.saveAndFlush(resource);
	}
	
}
