package com.gwtjs.icustom.simple.jaxrs.service.impl;


import com.gwtjs.icustom.simple.jaxrs.service.RestHelloService;

public class RestHelloServiceImpl implements RestHelloService {
	
	public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }
	
}