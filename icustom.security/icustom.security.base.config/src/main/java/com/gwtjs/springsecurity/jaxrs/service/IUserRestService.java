package com.gwtjs.springsecurity.jaxrs.service;

import java.util.List;

import com.gwtjs.springsecurity.entity.SysUser;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/api/application.wadl
 * 
 * http://localhost:8080/api/user/findAllUserList
 * 
 * @author aGuang
 *
 */
@Path("/user")
@Component
@Produces(MediaType.APPLICATION_JSON)
public interface IUserRestService {
	
	/**
	 * 查询所有用户-第一个-测试型
	 * 
	 * @return
	 */
	@GET
	@Path("/findAllUserList")
	List<SysUser> findAllUserList();
	
	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	@POST
	@Path("/insert")
	int insert(List<SysUser> userList);
	
}
