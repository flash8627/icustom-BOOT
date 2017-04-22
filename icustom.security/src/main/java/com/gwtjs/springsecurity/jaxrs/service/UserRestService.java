package com.gwtjs.springsecurity.jaxrs.service;

import java.util.List;

import com.gwtjs.springsecurity.entity.SysUser;

public interface UserRestService {
	
	/**
	 * 查询所有用户-第一个-测试型
	 * @return
	 */
	List<SysUser> findAllUserList();
	
	/**
	 * 批量插入用户数据
	 * @param userList
	 * @return
	 */
	int insert(List<SysUser> userList);
	
	/**
	 * 查询用户主键ID最大值
	 * @return
	 */
	int findUserIdCount();
	
}
