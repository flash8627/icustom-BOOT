package com.gwtjs.springsecurity.jaxrs.dao;


import org.apache.ibatis.annotations.Mapper;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.springsecurity.entity.SysRole;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysRoleDao {
	
	public Integer findRoleIdCount();
	
	public int insert(SysRole role);
	
	public int delete(SysRole role);
	
	public int update(SysRole role);
	
	public PagedResult<SysRole> findRolePage(SysRole role,PageVO page);
	
}
