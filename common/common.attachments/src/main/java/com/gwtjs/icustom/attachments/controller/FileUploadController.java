package com.gwtjs.icustom.attachments.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传的Controller
 * 
 * create 2017年1月11日
 */
@Controller
public class FileUploadController {

	// 页面访问路径为
	@RequestMapping(value = {"/attachments","/attachments/index","/attachments/upload/index"}, method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

	// 页面访问路径为：http://ip:port/upload/batch
	@RequestMapping(value = "/attachments/uploads", method = RequestMethod.GET)
	public String mutifileUpload() {
		return "/mutifileupload2";
	}

	/**
	 * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
	 *
	 * @param request
	 * @return
	 * 
	 * @author a g
	 * @create 2017年1月11日
	 */
	@RequestMapping(value = "/attachments/upload/files", method = RequestMethod.POST)
	public @ResponseBody String batchUpload(HttpServletRequest request) {
		request.getUserPrincipal();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		System.out.println("files.size "+files.size());
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					stream = null;
					return "You failed to upload " + i + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + i + " because the file was empty.";
			}
		}
		return "upload successful";
	}
}