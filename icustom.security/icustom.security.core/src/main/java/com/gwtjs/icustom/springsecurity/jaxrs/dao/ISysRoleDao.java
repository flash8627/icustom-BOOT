package com.gwtjs.icustom.springsecurity.jaxrs.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
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
	
	/*public Integer findRoleIdCount();
	
	public int insert(@Param("vo")SysRoleVO role);
	
	public int delete(@Param("vo")SysRoleVO role);
	
	public int update(@Param("vo")SysRoleVO role);*/
	
	public PagedResult<SysRoleVO> findRolePage(@Param("vo") SysRoleVO role,@Param("page") PageVO page);
	
}
