package com.gwtjs.springsecurity.jaxrs.service;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.springsecurity.entity.SysRole;

@Path("/role")
@Component @Service  
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON )
public interface IRoleRestService {

	@POST @Path("/insert")
	public int insert(SysRole role);
	
	@DELETE @Path("/delete")
	public int delete(SysRole role);
	
	@PUT @Path("/update")
	public int update(SysRole role);
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	@GET @Path("/findRolePage/{curPage}/{pageSize}") 
	public PagedResult<SysRole> findRolePage(@QueryParam("")SysRole role,@PathParam("") PageVO page);

}
