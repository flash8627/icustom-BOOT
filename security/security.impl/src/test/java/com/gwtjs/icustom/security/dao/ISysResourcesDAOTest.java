package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SecurityImplMainApplication.class)
public class ISysResourcesDAOTest {
	
	@Inject
	private ISysResourcesDAO sysResourcesDAO;
	
	@Test
	public void contextLoads() {
		assertNotNull(sysResourcesDAO);
		System.out.println(sysResourcesDAO);
	}
	
	@Test
	public void findAuthResourcesTreeRootTest() {
		List<SysResourceVO>result =  sysResourcesDAO.findAuthResourcesTreeRoot();
		System.out.println("findAuthResourcesTreeRoot result:"+result);
	}
	
}
