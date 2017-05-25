package com.gwtjs.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gwtjs.core.ICustomCoreApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ICustomCoreApplication.class)
@WebAppConfiguration
public class SpringBootICustomApplicationTests {

	@Test
	public void contextLoads() {
	}

}
