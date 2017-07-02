package com.gwtjs.icustom.springsecurity.support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysRoleDao;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysUserDao;

/**
 * 认证管理器，实现用户认证的入口
 * <p>
 * 	以从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等
 * </p>
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ISysUserDao userDao;
	
	@Inject
	private ISysRoleDao	isysRoleDao;
	
	/**
	 * 用户登陆在这里
	 */
	@Override
	public UserDetails loadUserByUsername(String account)
			throws UsernameNotFoundException {
		// SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
		SysUserVO user = userDao.findByAccount(account);
		if (user == null) {
			throw new UsernameNotFoundException("account " + account + " not found");
		}else{
			Set<SysRoleVO> sysRoles = this.getUserRoles(isysRoleDao.findByUserRoles(user.getId()));
			user.setSysRoles(sysRoles);
		}
		// SecurityUser实现UserDetails并将SysUser的name映射为username
		SecurityUser seu = new SecurityUser(user);
		return seu;
	}
	
	/**
	 * 
	 */
	private Set<SysRoleVO> getUserRoles(List<SysRoleVO> list){
		Set<SysRoleVO> set = new HashSet<SysRoleVO>();
		for (SysRoleVO sysRole : list) {
			set.add(sysRole);
		}
		return set;
	}

}
