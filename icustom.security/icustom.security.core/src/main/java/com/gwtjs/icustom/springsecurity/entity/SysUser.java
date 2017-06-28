package com.gwtjs.icustom.springsecurity.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gwtjs.core.entity.BaseResource;


public class SysUser extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807693589347371291L;
	
	private Integer id;

	
	private String account; // 用户帐号
	private String username; // 用户姓名
	private String email;// 用户邮箱
	private String password;// 用户密码
	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

	public SysUser() {
	}

	public SysUser(String username, String account, String email,
			String password, Date dob, Set<SysRole> sysRoles) {
		this.account = account;
		this.username = username;
		this.email = email;
		this.password = password;
		this.sysRoles = sysRoles;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Set<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", email="
				+ email + ", password=" + password + ", account=" + account
				+ ", sysRoles=" + sysRoles + "]";
	}

}
