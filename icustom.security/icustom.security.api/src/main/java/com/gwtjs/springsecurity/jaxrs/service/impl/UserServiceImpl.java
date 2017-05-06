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

	public PagedResult<UserVO> findUserPage(UserVO user, PagerVO page) {
		PagedResult<UserVO> result = new PagedResult<UserVO>();
		result.setPageVO(page);
		List<UserVO> users = new ArrayList<>();
		users.add(user);
		result.setResult(users);
		return result;
	}

	public List<UserVO> findUsers(UserVO user, PagerVO page) {
		return null;
	}

	@Override
	public int insert(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
