package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import com.gwtjs.springsecurity.jaxrs.service.HelloService;

@Api("/sayHello")
public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}
