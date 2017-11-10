package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.security.entity.SysAuthoritiesVO;

public interface IAuthoritiesDAO{
	
	//权限框架专用
	List<String> getSysAuthorities();
	
	/* 以下为维护数据专用　 */
	//
	SysAuthoritiesVO getByPathAuthorities(SysAuthoritiesVO reg);
	
	//
	SysAuthoritiesVO findItem(@Param("authId")Integer authId);
	
	//
	List<SysAuthoritiesVO> findAuthoritiesList(SysAuthoritiesVO record,PageVO page);
	
	//
	List<SysAuthoritiesVO> findAuthoritiesTree(SysAuthoritiesVO record);

	//
	int findAuthoritiesListCount(SysAuthoritiesVO record,PageVO page);
	
	//
	int batchRemovePks(List<SysAuthoritiesVO> records);

	//
	int batchUpdate(List<SysAuthoritiesVO> records);

	//
	int batchInsert(List<SysAuthoritiesVO> records);
	
}
