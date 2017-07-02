package com.gwtjs.icustom.springsecurity.entity;

import java.util.List;

public class SysModuleVO extends SysResourceVO {

	/**
	 */
	private static final long serialVersionUID = 2050618271618805418L;
	
	// 子节点
	private List<SysModuleVO> children;
	// 上级名称
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<SysModuleVO> getChildren() {
		return children;
	}

	public void setChildren(List<SysModuleVO> children) {
		this.children = children;
	}

}
