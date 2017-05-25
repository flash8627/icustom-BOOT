package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.HttpStatusCode;
import com.gwtjs.springsecurity.jaxrs.service.IApplicationUserService;

@Path("/user")
@Api("/user")
public class ApplicationUserService implements IApplicationUserService {

	// AuthenicateUser
	public ResultWrapper authenicateUser(String route) {
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	// Logout
	public ResultWrapper logout() {
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper login() {
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper registerUser() {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getUser() {
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper updateUser() {
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

}
