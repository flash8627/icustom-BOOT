package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

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
	SysUserVO findUser(@Param("id") Integer id);
	
	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUserVO findByUsername(@Param("username") String username);
	
	/**
	 * 查询某用户-第一个-测试型
	 * 
	 * @return
	 */
	SysUserVO findByAccount(@Param("account") String account);

	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	List<SysUserVO> findAllUserList();
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	PagedResult<SysUserVO> findUserPage(@Param("user") SysUserVO user,@Param("page") PageVO page);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int insert(SysUserVO user);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int update(SysUserVO user);
	
	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int updatePwd(SysUserVO user);

	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	int batchInsert(List<SysUserVO> userList);

	/**
	 * 查询用户主键ID最大值
	 * 
	 * @return
	 */
	int findUserIdCount();

}
