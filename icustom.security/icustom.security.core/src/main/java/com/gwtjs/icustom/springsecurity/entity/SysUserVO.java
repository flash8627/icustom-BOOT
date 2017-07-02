package com.gwtjs.icustom.springsecurity.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gwtjs.core.entity.BaseResource;

public class SysUserVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807693589347371291L;

	private long id;

	private String account; // 用户帐号
	private String username; // 用户姓名
	private String email;// 用户邮箱
	private String password;// 用户密码

	private String userDesc; // 用户描述

	private Date validStart;// 有效期开始
	private Date validEnd;// 有效期结束

	private Set<SysRoleVO> sysRoles = new HashSet<SysRoleVO>(0);// 用户的角色

	public SysUserVO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<SysRoleVO> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(Set<SysRoleVO> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Date getValidStart() {
		return validStart;
	}

	public void setValidStart(Date validStart) {
		this.validStart = validStart;
	}

	public Date getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(Date validEnd) {
		this.validEnd = validEnd;
	}

}
