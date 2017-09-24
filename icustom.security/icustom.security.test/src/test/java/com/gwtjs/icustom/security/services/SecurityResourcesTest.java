package com.gwtjs.icustom.security.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gwtjs.icustom.SecurityMainApiApplicationTest;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.security.dao.ISysResourcesDAO;
import com.gwtjs.icustom.security.entity.SysResourcesVO;
import com.gwtjs.icustom.security.services.ISysResourcesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityMainApiApplicationTest.class)
@WebAppConfiguration
public class SecurityResourcesTest extends SecurityMainApiApplicationTest {

	/*
	 * @Autowired private ISysResourceDao sysResourceDao;
	 
	@Inject
	private ISysResourcesDAO resourcesDAO;
	
	@Autowired
	private ISysResourcesService resourcesService;
	
	*/
	@Inject
	private ISysResourcesDAO isysResourcesDAO;
	
	@Test
	public void serviceAocTest() {
		assertTrue(isysResourcesDAO != null);
	}

	@Test
	public void findAllTest() {
		
	}

}
