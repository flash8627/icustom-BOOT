package com.gwtjs.icustom.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

public interface ISysUserMgrDao{
	
	//
	PagedResult<SysUserVO> queryUserByPage(SysUserVO record);
	
	/**
	 *@author aGuang 2011-3-30 下午03:51:48
	 *@param account
	 *@param session
	 *@return  字符数组
	 */
	/**用户权限名称*/
	List<String> loadUserAuthorities(SysUserVO record);
	
	/**
	 * 根据用户账号返回SysUsers实例对象。
	 * 
	 * @author aGuang 2011-4-8 下午01:53:05
	 *@param userAccount
	 *            用户账号，比如admin等。
	 *@return SysUsers实例对象。
	 */
	public SysUserVO findByUserAccount(SysUserVO record);
	
	//
	SysUserVO findByItem(SysUserVO record);
	
	//
	SysUserVO findItem(@Param("userId")long userId);

	PagedResult<SysUserVO> findUserByPage(SysUserVO record,PageVO page);

	//
	int batchRemovePks(List<SysUserVO> records);

	//
	int batchUpdate(List<SysUserVO> records);

	//
	int batchInsert(List<SysUserVO> records);
	
	int updateUserPwd(SysUserVO record);
	
}
