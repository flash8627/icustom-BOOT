package com.gwtjs.springsecurity.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.gwtjs.core.entity.BaseResource;

@XmlRootElement
public class UserVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2807693589347371291L;
	private Integer id;

	private Integer userId;

	private String username; // 用户名

	public Integer getId() {
		return id;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
