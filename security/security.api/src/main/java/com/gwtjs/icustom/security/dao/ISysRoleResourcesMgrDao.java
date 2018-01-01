package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.springsecurity.entity.SysRoleResourceVO;

/**
 * 角色的资源
 * @author aGuang
 *
 */
public interface ISysRoleResourcesMgrDao {
	
	//角色的资源
	List<SysRoleResourceVO> findByRoleResource(@Param("roleId")long roleId);
	
}

