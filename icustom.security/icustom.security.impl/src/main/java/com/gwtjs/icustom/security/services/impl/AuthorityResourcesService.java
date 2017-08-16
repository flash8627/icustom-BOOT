package com.gwtjs.icustom.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.security.dao.IAuthoritiesResourcesDAO;
import com.gwtjs.icustom.security.entity.SysAuthoritiesResourcesVO;
import com.gwtjs.icustom.security.services.IAuthorityResourcesService;

@Named("authorityResourcesService")
public class AuthorityResourcesService implements
		IAuthorityResourcesService {
	
	private static final Logger log = LoggerFactory.getLogger(SysResourcesService.class);
	
	@Inject
	private IAuthoritiesResourcesDAO authoritiesResourcesDao;

	@Override
	public List<SysAuthoritiesResourcesVO> findAuthoritiesResources(long authId) {
		log.debug(authId+"");
		return authoritiesResourcesDao.findAuthoritiesResources(authId);
	}

	@Override
	public ResultWrapper batchRemovePks(List<SysAuthoritiesResourcesVO> list) {
		authoritiesResourcesDao.batchRemovePks(list);
		return ResultWrapper.successResult(list);
	}

	@Override
	public ResultWrapper batchInsert(List<SysAuthoritiesResourcesVO> list) {
		if(list.size()<1){
			return ResultWrapper.faultResult("没有条目保存!!!",list);
		}
		
		authoritiesResourcesDao.removeAuthResources(list.get(0).getAuthId());
		list = setRecordsUser(list);
		authoritiesResourcesDao.batchInsert(list);
		List<SysAuthoritiesResourcesVO> result = new ArrayList<SysAuthoritiesResourcesVO>();
		for (SysAuthoritiesResourcesVO reg : list) {
			SysAuthoritiesResourcesVO vo = authoritiesResourcesDao.findAuthoritiesResourcesItem(reg);
			result.add(vo);
		}
		return ResultWrapper.successResult(result);
	}
	
	/**
	 * 设置当前操作用户
	 * 
	 * @param records
	 * @return
	 */
	private List<SysAuthoritiesResourcesVO> setRecordsUser(List<SysAuthoritiesResourcesVO> records) {
		List<SysAuthoritiesResourcesVO> result = new ArrayList<SysAuthoritiesResourcesVO>();
		long createdUser = new Long(10001);

		for (SysAuthoritiesResourcesVO vo : records) {
			vo.setCreatedUser(createdUser);
			vo.setUpdateLastUser(createdUser);
			result.add(vo);
		}
		return result;
	}

}
