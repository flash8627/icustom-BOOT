package com.gwtjs.icustom.attachments.model;

public class FileUploadStatus {

	private long bytesRead = 0L;
	private long contentLength = 0L;
	private int items;

	public FileUploadStatus() {
		bytesRead = 0L;
		contentLength = 0L;
	}

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

}
