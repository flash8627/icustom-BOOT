package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.security.entity.SysRolesAuthoritiesVO;

public interface IRoleAuthoritiesDao {
	
	int batchRemovePks(List<SysRolesAuthoritiesVO> list);
	
	int batchInsert(List<SysRolesAuthoritiesVO> list);
	
	SysRolesAuthoritiesVO findByRoleAuthorities(SysRolesAuthoritiesVO vo);
	
	List<SysRolesAuthoritiesVO> findRoleAuthorities(@Param("roleId")long roleId);
	
}
