package com.gwtjs.springsecurity.jaxrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.springsecurity.entity.SysUser;

/**
 * 权限--用户管理--mybatis接口数据管理
 * 
 * @author aGuang
 */
@Mapper
public interface ISysUserDao {

	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUser findUser(@Param("id") Integer id);
	
	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUser findUserByname(@Param("name") String name);

	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	List<SysUser> findAllUserList();
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	List<SysUser> findUserList(SysUser user,PagerVO page);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int insert(SysUser user);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int update(SysUser user);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int batchInsert(List<SysUser> userList);

	/**
	 * 查询用户主键ID最大值
	 * 
	 * @return
	 */
	int findUserIdCount();

}
