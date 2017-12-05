package com.gwtjs.icustom.springsecurity.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gwtjs.icustom.entity.BaseResource;

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
	private Integer userEnabled;

	private String remark; // 用户描述

	private Date effectiveDateStart;// 有效期开始
	private Date effectiveDateEnd;// 有效期结束

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getEffectiveDateStart() {
		return effectiveDateStart;
	}

	public void setEffectiveDateStart(Date effectiveDateStart) {
		this.effectiveDateStart = effectiveDateStart;
	}

	public Date getEffectiveDateEnd() {
		return effectiveDateEnd;
	}

	public void setEffectiveDateEnd(Date effectiveDateEnd) {
		this.effectiveDateEnd = effectiveDateEnd;
	}

	public Integer getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(Integer userEnabled) {
		this.userEnabled = userEnabled;
	}

	@Override
	public String toString() {
		return "{'id':'" + id + "', 'account':'" + account + "', 'username':'"
				+ username + "', 'email':'" + email + "', 'password':'"
				+ password + "', 'remark':'" + remark
				+ "', 'effectiveDateStart':'" + effectiveDateStart
				+ "', 'effectiveDateEnd':'" + effectiveDateEnd
				+ "', 'sysRoles':" + sysRoles + "}";
	}

}
