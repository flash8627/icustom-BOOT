package com.gwtjs.icustom.springsecurity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;
import com.gwtjs.icustom.springsecurity.entity.SysRoleResourceVO;

/**
 * 权限--资源目录--mybatis接口数据管理
 * 
 * @author aGuang
 *
 */
@Mapper
public interface ISysResourceDao {

	// 1027新增
	List<SysResourceVO> findResourcesTreeRoot();
		
	// 1027新增
	List<SysResourceVO> findResourcesTree(SysResourceVO record);

	int saveOrUpdate(List<SysResourceVO> sys);

	List<SysResourceVO> findAll();

	PagedResult<SysResourceVO> findResourcePage(@Param("vo") SysResourceVO sys,
			@Param("page") PageVO page);

	List<SysResourceVO> findResourcesById(
			@Param("list") List<SysRoleResourceVO> roleIds);

}
