package com.gwtjs.icustom;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.security.dao.ISysResourcesDAO;
import com.gwtjs.icustom.security.services.ISysResourcesService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityImplMainApplication.class)
@WebAppConfiguration
//@EnableAutoConfiguration
@ContextConfiguration(locations = { 
		"classpath:spring.xml",
		"classpath*:/config/*-service.xml"})
@ImportResource({ 
	"classpath:spring.xml",
	"classpath*:/config/*.configs.xml",
	"classpath*:/config/*.beans.xml",
	"classpath*:/config/*.service.xml",
	"classpath*:/config/*.services.xml",
	"classpath*:/config/*.exceptions.xml",
	"classpath*:/config/*-service.xml"
	})
@ComponentScan({ "com.gwtjs.icustom" })
public class SecurityMainApiApplicationTest {

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	@Autowired
	private ISysResourcesService isysResourcesService;

	@Inject
	private ISysResourcesDAO isysResourcesDAO;

	@Test
	public void serviceAocTest() {
		assertTrue(isysResourcesDAO != null);
		assertTrue(isysResourcesService != null);
	}

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
		// resourcesService = (ISysResourcesService)
		// Appctx.getObject("resourcesService");
	}

	@Test
	public void contextLoads() {
		System.out.println(mvc);
	}
	
}
