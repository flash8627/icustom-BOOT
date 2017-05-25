package com.gwtjs.springsecurity.jaxrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.springsecurity.entity.SysResource;

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
	
}
