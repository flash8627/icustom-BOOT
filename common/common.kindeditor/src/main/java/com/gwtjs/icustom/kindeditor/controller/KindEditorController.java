package com.gwtjs.icustom.kindeditor.controller;

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
public class KindEditorController {

	// 页面访问路径为
	@RequestMapping(value = {"/kindeditor","/kindeditor/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println(request);
		String content = request.getParameter("content1");
		if(null!=content&&!"".equals(content)) {
			content = htmlspecialchars(content);
		}
		return "/index";
	}
	
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}