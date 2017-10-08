package com.gwtjs.icustom.attachments.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.gwtjs.icustom.attachments.model.FileUploadStatus;

/**
 * 上传监听
 * @author aGuang
 *
 */
@Component
public class FileUploadProgressListener implements ProgressListener {

	private HttpSession session;

	public void setSession(HttpSession session){
		this.session=session;
		FileUploadStatus status = new FileUploadStatus();
		session.setAttribute("status", status);
	}
	
	/*
	 * bytesRead 到目前为止读取文件的比特数 contentLength 文件总大小 items 目前正在读取第几个文件
	 */
	@Override
	public void update(long bytesRead, long contentLength, int items) {
		FileUploadStatus status = (FileUploadStatus) session.getAttribute("status");
		status.setBytesRead(bytesRead);
		status.setContentLength(contentLength);
		status.setItems(items);
	}

}
