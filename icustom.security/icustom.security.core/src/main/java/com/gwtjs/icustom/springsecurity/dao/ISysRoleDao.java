package com.gwtjs.icustom.springsecurity.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysRoleDao {
	
	List<SysRoleVO> findAll();

	SysRoleVO findByRoleName(@Param("roleName") String roleName);
	
	List<SysRoleVO> findByUserRoles(@Param("userId") long userId);
	
	int saveRoles(@Param("roles")List<SysRoleVO> role);
	
	public PagedResult<SysRoleVO> findRolePage(@Param("vo") SysRoleVO role,@Param("page") PageVO page);
	
}
