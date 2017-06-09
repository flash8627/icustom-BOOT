package com.gwtjs.icustom.session.redis.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动之后进行访问测试，首先访问8080端口的tomcat，返回 获取【下载地址】   ：
    {"request Url":"http://localhost:8080/admin/v1/first"}  
 接着，我们访问8080端口的sessions，返回：
    {"sessionId":"efcc85c0-9ad2-49a6-a38f-9004403776b5","message":"http://localhost:8080/admin/v1/first"}  
最后，再访问9090端口的sessions，返回：
    {"sessionId":"efcc85c0-9ad2-49a6-a38f-9004403776b5","message":"http://localhost:8080/admin/v1/first"}  
可见，8080与9090两个服务器返回结果一样，实现了session的共享
如果此时再访问9090端口的first的话，首先返回：
    {"request Url":"http://localhost:9090/admin/v1/first"}  
而两个服务器的sessions都是返回：
    {"sessionId":"efcc85c0-9ad2-49a6-a38f-9004403776b5","message":"http://localhost:9090/admin/v1/first"}  
 * @author aGuang
 *
 */

@RestController
@RequestMapping(value = "/admin/v1")
public class QuickRun {
	
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public Map<String, Object> firstResp(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url",
				request.getRequestURL());
		map.put("request Url", request.getRequestURL());
		return map;
	}

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public Object sessions(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("map"));
		return map;
	}
}
