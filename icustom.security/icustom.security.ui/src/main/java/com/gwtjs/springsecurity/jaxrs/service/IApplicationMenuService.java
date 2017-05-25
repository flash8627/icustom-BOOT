package com.gwtjs.springsecurity.jaxrs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.SysResource;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/") 
@Component
@Service  
public interface IApplicationMenuService {
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	@GET
	@Path("/main/InitializeApplication")
	List<SysResource> initializeApplication();
	
	@GET
	@Path("/main/AuthenicateUser")
	ResultWrapper authenicateUser(String route);
	
}
