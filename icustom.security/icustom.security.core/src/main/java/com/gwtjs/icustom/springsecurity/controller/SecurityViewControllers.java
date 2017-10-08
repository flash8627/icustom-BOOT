package com.gwtjs.icustom.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityViewControllers {

	// 页面访问路径为
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String upload() {
		return "login";
	}

	// 页面访问路径为
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "accessDenied";
	}

	// 页面访问路径为
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}

}
