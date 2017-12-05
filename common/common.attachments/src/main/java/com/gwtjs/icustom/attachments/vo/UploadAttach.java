package com.gwtjs.icustom.attachments.vo;

public class UploadAttach {

	private long maxFileSize = 1000000L;

	private long maxRequestSize = 1000000L;

	private String attachPath = "upfile";

	public long getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(long maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public long getMaxRequestSize() {
		return maxRequestSize;
	}

	public void setMaxRequestSize(long maxRequestSize) {
		this.maxRequestSize = maxRequestSize;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

}
