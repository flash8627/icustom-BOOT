package com.gwtjs.icustom.springsecurity.entity;

import java.util.Date;

import com.gwtjs.core.entity.BaseResource;

public class SysResourceRole extends BaseResource {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4203811499633005155L;

	private int id;

	private String roleId; // 角色ID

	private String resourceId;// 资源ID

	private Date updateTime;// 更新时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
