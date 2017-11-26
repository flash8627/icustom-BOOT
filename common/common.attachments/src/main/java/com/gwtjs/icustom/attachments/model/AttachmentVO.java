package com.gwtjs.icustom.attachments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gwtjs.icustom.entity.BaseResource;

@JsonIgnoreProperties(ignoreUnknown = true, value = { "filePath", "appName", "scope", "currentUserId", "createdBy",
		"lastUpdatedBy" })
public class AttachmentVO extends BaseResource {
	
	private static final long serialVersionUID = -3728375810761931664L;
	
	private String attachmentMask;
	private int attachmentId;
	private int batchId;
	private String attachmentType;
	private String fileName;
	private String filePath;
	private Long fileSize;
	private String status;
	private String downloadUrl;
	private String deleteUrl;

	public String getAttachmentMask() {
		return attachmentMask;
	}

	public void setAttachmentMask(String attachmentMask) {
		this.attachmentMask = attachmentMask;
	}

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

}
