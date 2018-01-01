package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;

public interface ISysUserRolesMgrDao{
	
	/**
	 * 某用户的所有角色
	 * @param userId
	 * @return
	 */
	List<SysRoleVO> findByUserRoles(@Param("userId") long userId);
	
}
