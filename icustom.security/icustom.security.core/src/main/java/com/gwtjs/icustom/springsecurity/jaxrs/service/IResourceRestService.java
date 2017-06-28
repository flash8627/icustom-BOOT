package com.gwtjs.icustom.springsecurity.jaxrs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.springsecurity.entity.SysResource;

@Path("/resource")
@Component @Service  
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public interface IResourceRestService {
	
	@POST @Path("/insert")
	int insert(SysResource sys);
	
	@PUT @Path("/update")
	int update(SysResource sys);
	
	@DELETE @Path("/delete")
	public int delete(SysResource role);
	
	@GET
	@Path("/findAll")
	List<SysResource> findAll();
	
}
