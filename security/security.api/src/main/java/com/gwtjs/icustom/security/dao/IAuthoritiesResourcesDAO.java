package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysAuthoritiesResourcesVO;

public interface IAuthoritiesResourcesDAO {
	
	List<String> loadResource(String auth);
	
	List<SysAuthoritiesResourcesVO> findAuthoritiesResources(@Param("authId") long authId);
	
	SysAuthoritiesResourcesVO findAuthoritiesResourcesItem(SysAuthoritiesResourcesVO ar);

	int batchRemovePks(List<SysAuthoritiesResourcesVO> list);
	
	int removeAuthResources(@Param("authId") long authId);
	
	int batchInsert(List<SysAuthoritiesResourcesVO> list);
	
}
