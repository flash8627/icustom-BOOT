package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.springsecurity.entity.UserVO;
import com.gwtjs.springsecurity.jaxrs.service.IUserService;
@Path("/user")
@Api("/user")
public class UserServiceImpl implements IUserService {
	
	public PagedResult<UserVO> findUserPage(UserVO user,PagerVO page) {
		PagedResult<UserVO> result = new PagedResult<UserVO>();
		result.setPageVO(page);
		List<UserVO> users = new ArrayList<>();
		users.add(user);
		result.setResult(users);
		return result;
	}
	
	public String findUsers(UserVO user,PagerVO page) {
		return buildResult(user, page);
	}
	
	private String buildResult(UserVO user,PagerVO page) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("pageSize:").append(page.getPageSize());
		buffer.append(",");
		buffer.append("curPage:").append(page.getCurPage());
		buffer.append(",");
		buffer.append("userId:").append(user.getUserId());
		buffer.append(",");
		buffer.append("username:").append(user.getUsername());
		buffer.append("}");
		
		return buffer.toString();
	}
	
	/*模拟服务*/
	private PagedResult<UserVO> buildUserPage(UserVO user,PagerVO page){
		PagedResult<UserVO> result = new PagedResult<UserVO>();
		result.setPageVO(page);
		List<UserVO> userList = new ArrayList<>();
		UserVO vo = new UserVO();
		vo.setUserId(user.getUserId());
		vo.setUsername(user.getUsername()+"123");
		userList.add(vo);
		result.setResult(userList);
		return result;
	}
	
}
