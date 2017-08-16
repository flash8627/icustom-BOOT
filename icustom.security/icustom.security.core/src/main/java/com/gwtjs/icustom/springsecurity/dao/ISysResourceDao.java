package com.gwtjs.icustom.springsecurity.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;
import com.gwtjs.icustom.springsecurity.entity.SysRoleResourceVO;

/**
 * 权限--资源目录--mybatis接口数据管理
 * 
 * @author aGuang
 *
 */
@Mapper @Named("isysResourceDao")/* @Component  @Service*/
public interface ISysResourceDao {

	// 1027新增
	List<SysResourceVO> findResourcesTree(@Param("parentId") long parentId);

	int saveOrUpdate(List<SysResourceVO> sys);

	List<SysResourceVO> findAll();

	PagedResult<SysResourceVO> findResourcePage(@Param("vo") SysResourceVO sys,
			@Param("page") PageVO page);

	List<SysResourceVO> findResourcesById(
			@Param("list") List<SysRoleResourceVO> roleIds);

}
