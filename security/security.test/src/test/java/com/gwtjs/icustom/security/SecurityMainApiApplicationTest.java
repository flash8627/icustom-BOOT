package com.gwtjs.icustom.security;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.Ordered;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gwtjs.icustom.autoconfiguration.WebApplicationConfig;
import com.gwtjs.icustom.security.dao.ISysResourcesDAO;
import com.gwtjs.icustom.security.services.ISysResourcesService;
import com.gwtjs.icustom.springsecurity.support.Appctx;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityMainApiApplicationTest.class)
@WebAppConfiguration
@Configuration @EnableAutoConfiguration
public class SecurityMainApiApplicationTest {
	
	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;
	
	/*@Autowired
	private ISysResourcesService ISysResourcesService;*/
	
	@Inject
	private ISysResourcesDAO isysResourcesDAO;
	
	@Test
	public void serviceAocTest() {
		assertTrue(isysResourcesDAO != null);
	}

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
		//resourcesService = (ISysResourcesService) Appctx.getObject("resourcesService");
	}

	@Test
	public void contextLoads() {
		System.out.println(mvc);
	}

}
