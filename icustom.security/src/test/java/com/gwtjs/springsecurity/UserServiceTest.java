package com.gwtjs.springsecurity;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.springsecurity.service.UserService;

public class UserServiceTest extends MainApplicationTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testServiceInit()
	{
		System.out.println(userService);
	}
	
}
