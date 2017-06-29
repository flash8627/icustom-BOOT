package com.gwtjs.icustom.springsecurity.jaxrs.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.entity.SysRole;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysRoleDao {
	
	List<SysRole> findAll();
	
	SysRole findByRoleName(@Param("roleName") String roleName);
			
	public Integer findRoleIdCount();
	
	public int insert(@Param("vo")SysRole role);
	
	public int delete(@Param("vo")SysRole role);
	
	public int update(@Param("vo")SysRole role);
	
	public PagedResult<SysRole> findRolePage(@Param("vo") SysRole role,@Param("page") PageVO page);
	
}
