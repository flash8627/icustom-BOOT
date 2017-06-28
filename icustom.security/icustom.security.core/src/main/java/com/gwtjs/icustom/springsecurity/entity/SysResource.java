package com.gwtjs.icustom.springsecurity.entity;

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

	@Override
	public String toString() {
		return "SysResource [id=" + id + ", resourceString=" + resourceString
				+ ", resourceId=" + resourceId + ", remark=" + remark
				+ ", resourceName=" + resourceName + ", methodName="
				+ methodName + ", methodPath=" + methodPath + "]";
	}

}
