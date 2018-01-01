package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.springsecurity.entity.SysRoleResourceVO;
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;

public interface ISysUserRolesMgrDao{
	
	/**
	 * 某用户的所有角色
	 * @param userId
	 * @return
	 */
	List<SysRoleVO> findByUserRoles(@Param("userId") long userId);
	
	/**批量新增用户的角色*/
	int saveOrUpdate(List<SysRoleVO> records);
	
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int batchRemovePks(List<SysRoleVO> records);
	/**
	 * 删除数据,批量
	 * @param records
	 * @return
	 */
	int removeRoleResources(@Param("userId")long userId);
}
