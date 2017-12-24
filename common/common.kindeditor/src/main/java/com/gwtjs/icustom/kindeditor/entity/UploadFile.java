package com.gwtjs.icustom.kindeditor.entity;

public class UploadFile {

	/*
	 * (oldName); uploadFile.setPath(savePath + fileName); uploadFile.setSize(size);
	 * uploadFile.setCreateTime(createTime); uploadFile.setExt(ext);
	 */

	private String name;
	private String path;
	private String size;
	private String createTime;
	private String ext;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
