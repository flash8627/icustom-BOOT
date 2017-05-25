package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.ResultWrapper;

@Path("/user")
@Service
@Produces(MediaType.APPLICATION_JSON)
public interface IApplicationUserService {

	@GET
	@Path("AuthenicateUser")
	public ResultWrapper authenicateUser(@QueryParam("route") String route);

	@GET
	@Path("Logout")
	public ResultWrapper logout();

	@POST
	@Path("Login")
	public ResultWrapper login();

	@POST
	@Path("RegisterUser")
	public ResultWrapper registerUser();

	@GET
	@Path("GetUser")
	public ResultWrapper getUser();

	@PUT
	@Path("UpdateUser")
	public ResultWrapper updateUser();

}
