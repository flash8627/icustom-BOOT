package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysResource;

/**
 * 权限--资源目录--mybatis接口数据管理
 * @author aGuang
 *
 */
@Mapper
public interface ISysResourceDao {
	
	int insert(SysResource sys);
	
	int update(SysResource sys);
	
	List<SysResource> findAll();
	
	PagedResult<SysResource> findResourcePage(@Param("vo")SysResource sys,@Param("page")PageVO page);
	
	List<SysResource> findByRoleName(@Param("roleIds")List<Integer> roleIds);
	
}
