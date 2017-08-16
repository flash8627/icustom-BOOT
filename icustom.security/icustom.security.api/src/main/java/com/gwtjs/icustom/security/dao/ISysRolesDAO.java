package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.entity.SysRolesVO;

public interface ISysRolesDAO {
	
	//
	SysRolesVO findByItem(SysRolesVO record);
	
	//
	SysRolesVO findItem(@Param("roleId")long roleId);

	//
	PagedResult<SysRolesVO> findSysRoles(SysRolesVO record,PageVO page);

	//
	int batchRemovePks(List<SysRolesVO> records);

	//
	int batchUpdate(List<SysRolesVO> records);

	//
	int batchInsert(List<SysRolesVO> records);
	
}
