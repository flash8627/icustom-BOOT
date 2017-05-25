package com.gwtjs.springsecurity.entity;

import java.util.Date;

import com.gwtjs.core.entity.BaseResource;

public class SysResource extends BaseResource {

	/***/
	private static final long serialVersionUID = -8724114844194419901L;

	private Integer id;

	private String resourceString;// url

	private String resourceId;// 资源ID

	private String remark;// 备注

	private String resourceName;// 资源名称

	private String methodName;// 资源所对应的方法名

	private String methodPath;// 资源所对应的包路径

	private Integer order;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceString() {
		return resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodPath() {
		return methodPath;
	}

	public void setMethodPath(String methodPath) {
		this.methodPath = methodPath;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public SysResource(long createdUser, Date createdDate, long updateLastUser,
			Date updateLastDate, String language, Integer orderCode) {
		super(createdUser, createdDate, updateLastUser, updateLastDate,
				language, orderCode);
	}

	public SysResource(long createdUser, Date createdDate, long updateLastUser,
			Date updateLastDate, String language, Integer orderCode,
			Integer id, String resourceString, String remark,
			String resourceName,Integer validFlag, Integer order) {
		super(createdUser, createdDate, updateLastUser, updateLastDate,
				language, orderCode);
		this.id = id;
		this.resourceString = resourceString;
		this.remark = remark;
		this.resourceName = resourceName;
		this.order = order;
	}

	public SysResource(Integer id,String resourceName, String resourceString, String remark,
			boolean validFlag, int orderCode) {
		this.id = id;
		this.resourceString = resourceString;
		this.remark = remark;
		this.resourceName = resourceName;
		this.order = orderCode;
	}
	
}
