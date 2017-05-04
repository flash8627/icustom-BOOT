package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.springsecurity.entity.UserVO;

@Path("/user")
@Service @Produces("application/json") @Consumes(MediaType.APPLICATION_JSON) 
public interface IUserService {
	
	@GET @Path("findUserPage/{curPage}/{pageSize}") 
	public PagedResult<UserVO> findUserPage(@QueryParam("")UserVO user,@PathParam("")PagerVO page);
	
	@GET @Path("findUsers/{curPage}/{pageSize}")
	public String findUsers(@QueryParam("")UserVO user,@PathParam("")PagerVO page);
	
}
