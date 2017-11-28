package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;

public interface ISysRolesDAO {
	
	//
	SysRoleVO findByItem(SysRoleVO record);
	
	//
	SysRoleVO findItem(@Param("roleId")long roleId);

	//
	PagedResult<SysRoleVO> findSysRoles(SysRoleVO record,PageVO page);

	//
	int batchRemovePks(List<SysRoleVO> records);

	//
	int batchUpdate(List<SysRoleVO> records);

	//
	int batchInsert(List<SysRoleVO> records);
	
}