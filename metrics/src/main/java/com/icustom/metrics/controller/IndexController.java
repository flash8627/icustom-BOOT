package com.icustom.metrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: IndexController Description:
 *
 * @author aGuang Date 2016/11/24
 */
@Controller
public class IndexController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
