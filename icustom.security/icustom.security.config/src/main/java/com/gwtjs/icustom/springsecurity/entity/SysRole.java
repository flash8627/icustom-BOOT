package com.gwtjs.icustom.springsecurity.entity;

import com.gwtjs.core.entity.BaseResource;

//系统角色表
public class SysRole extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048274432307622364L;

	private int id;

	private SysUser sysUser;// 角色对应的用户实体

	private String rolename;// 角色名称

	private Integer userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", sysUser=" + sysUser + ", rolename="
				+ rolename + ", userId=" + userId + "]";
	}

}
