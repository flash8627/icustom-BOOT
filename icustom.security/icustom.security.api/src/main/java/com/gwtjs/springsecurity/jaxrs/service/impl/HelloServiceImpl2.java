package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;

import com.gwtjs.springsecurity.jaxrs.service.HelloService;
@Path("/sayHello2")
@Api("/sayHello2")
public class HelloServiceImpl2 implements HelloService {

    public String sayHello(String a) {
        return "Hello2 " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}
