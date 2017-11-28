package com.gwtjs.icustom.security.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SecurityImplMainApplication.class)
public class ResourcesServiceTest {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ResourcesServiceTest.class);
	
	@Inject
	private IResourcesService resourcesService;
	
	@Test
	public void contextLoads() {
		assertNotNull(resourcesService);
		log.info("IResourcesService",resourcesService);
	}
	
	@Test
	public void findResourcesListTest()
	{
		List<SysResourceVO> list = resourcesService.findResourcesList();
		log.info("findResourcesList List",list);
	}
	
	@Test
	public void findMenuTest()
	{
		List<SysResourceVO> list = resourcesService.findResourcesSiteMenu();
		log.info("findResourcesList List",list);
	}
	
}
