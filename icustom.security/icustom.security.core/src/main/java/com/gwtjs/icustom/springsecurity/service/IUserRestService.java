package com.gwtjs.icustom.springsecurity.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

/**
 * http://localhost:8080/api/application.wadl
 * 
 * http://localhost:8080/api/user/findAllUserList
 * 
 * @author aGuang
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user") 
@Component
@Service  
public interface IUserRestService {
	
	/**
	 * 用户登陆会用到
	 */
	public SysUserVO findByUsername(String username);
	
	/**
	 * 用户登陆会用到
	 */
	public SysUserVO findByAccount(String account);
	
	/**
	 * 批量插入用户数据
	 * 
	 * @param userList
	 * @return
	 */
	@POST
	@Path("/insert")
	int insert(List<SysUserVO> userList);
	
}
