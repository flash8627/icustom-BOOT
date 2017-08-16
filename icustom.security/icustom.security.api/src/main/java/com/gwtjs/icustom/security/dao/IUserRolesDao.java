package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysUsersRolesVO;

public interface IUserRolesDao {
	
	List<SysUsersRolesVO> findUserRoles(@Param("userId")long userId);
	
	SysUsersRolesVO findUserRole(SysUsersRolesVO userRole);
	
	int batchInsert(List<SysUsersRolesVO> list);
	
	int batchRemovePks(List<SysUsersRolesVO> list);
	
}
