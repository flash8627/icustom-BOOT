package com.gwtjs.springsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gwtjs.core.entity.BaseResource;

//系统角色表
@Entity
@Table(name = "sys_role_t")
public class SysRole extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048274432307622364L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 10)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	private SysUser sysUser;// 角色对应的用户实体

	@Column(name = "rolename", length = 100)
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
