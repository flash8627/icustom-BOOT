package com.gwtjs.icustom.springsecurity.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gwtjs.icustom.springsecurity.entity.SysUser;
import com.gwtjs.icustom.springsecurity.jaxrs.service.IUserRestService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRestService iuserRestService;

	@Override
	public UserDetails loadUserByUsername(String account)
			throws UsernameNotFoundException {
		// SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
		// 使用SysUser中的name作为用户名:
		SysUser user = iuserRestService.findByName(account);
		if (user == null) {
			throw new UsernameNotFoundException("account " + account
					+ " not found");
		}
		// SecurityUser实现UserDetails并将SysUser的name映射为username
		SecurityUser seu = new SecurityUser(user);
		return seu;
	}

}