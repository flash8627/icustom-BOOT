package com.gwtjs.icustom.security.entity;

import com.gwtjs.icustom.entity.BaseResource;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

public class SysUsersRolesVO extends BaseResource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6514505604498078008L;
	private long id;
	private SysUserVO sysUsers;
	private SysRolesVO sysRoles;
	private boolean enabled;
	private String remarks;// REMARKS;FGV

	/* 视图显示用 */
	private long userId;
	private long roleId;
	private String roleDesc;
	private String roleName;
	private String roleCode;

	public SysUsersRolesVO() {
	}

	public SysUsersRolesVO(long id, SysUserVO sysUsers, SysRolesVO sysRoles,
			boolean enabled, String remarks) {
		super();
		this.id = id;
		this.sysUsers = sysUsers;
		this.sysRoles = sysRoles;
		this.enabled = enabled;
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SysUserVO getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(SysUserVO sysUsers) {
		this.sysUsers = sysUsers;
	}

	public SysRolesVO getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(SysRolesVO sysRoles) {
		this.sysRoles = sysRoles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
