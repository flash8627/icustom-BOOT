package com.gwtjs.icustom.simple.jaxrs.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.gwtjs.icustom.simple.jaxrs.service.IRestHelloWorldService;

@Controller
public class RestHelloWorldService implements IRestHelloWorldService {
	
    public Map<String,Object> hello() {
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("code","1");
       map.put("codeMsg", "success");
       return map;
    }
	
}
