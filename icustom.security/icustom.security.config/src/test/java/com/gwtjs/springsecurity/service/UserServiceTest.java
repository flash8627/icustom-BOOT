package com.gwtjs.springsecurity.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.springsecurity.MainApplicationTest;

public class UserServiceTest extends MainApplicationTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testServiceInit()
	{
		System.out.println(userService);
	}
	
}
