package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysResourceRole;
import com.gwtjs.icustom.springsecurity.entity.SysRole;

/**
 * 权限--资源目录--mybatis接口数据管理
 * @author aGuang
 *
 */
@Mapper
public interface ISysResourceRoleDao {
	
	/**
	 * 查询角色的资源
	 * @param role
	 * @param page
	 * @return	
	 */
	PagedResult<SysResourceRole> findByRoleResource(@Param("roles")List<SysRole> list,@Param("page")PageVO page);
	
	List<SysResourceRole> findByRoleResource(@Param("roleId")int roleId);
	
}
