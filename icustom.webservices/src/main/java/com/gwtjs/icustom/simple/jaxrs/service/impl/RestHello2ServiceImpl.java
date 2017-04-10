package com.gwtjs.icustom.simple.jaxrs.service.impl;


import com.gwtjs.icustom.simple.jaxrs.service.RestHelloService;

public class RestHello2ServiceImpl implements RestHelloService{
		
	public String sayHello(String a) {
        return "Hello2 " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }
	
}

