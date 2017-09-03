package com.gwtjs.icustom.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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
import com.gwtjs.icustom.security.services.ISysResourcesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityMainApiApplicationTest.class)
@WebAppConfiguration
@Configuration
@ConditionalOnClass(WebApplicationConfig.class)
/* @PropertySource("classpath*:jdbc.oracle.properties") */
@ImportResource({ "classpath*:/config/*.configs.xml",
		"classpath*:/config/*.beans.xml",
		"classpath*:/config/*.service.xml",
		"classpath*:/config/*.services.xml",
		"classpath*:/config/*.exceptions.xml", })
// "classpath*:spring.xml"
@ComponentScan({ "com.gwtjs.icustom.filter", "com.gwtjs.icustom.servlet",
		"com.gwtjs.icustom.autoconfiguration" })
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE - 1)
public class SecurityMainApiApplicationTest {
	
	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
	}

	@Test
	public void contextLoads() {
		System.out.println(mvc);
	}

}
