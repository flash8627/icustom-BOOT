package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityImplMainApplication.class)
public class ISysRoleResourcesDAOTest {

	@Inject
	private ISysRolesMgrDao sysRolesMgrDao;
	@Inject
	private ISysResourcesMgrDao sysResourcesMgrDao;
	@Inject
	private ISysRoleResourcesMgrDao sysRoleResourcesMgrDao;

	@Test
	public void contextLoads() {
		assertNotNull(sysRolesMgrDao);
		System.out.println(sysRolesMgrDao);
		assertNotNull(sysResourcesMgrDao);
		System.out.println(sysResourcesMgrDao);
		assertNotNull(sysRoleResourcesMgrDao);
		System.out.println(sysRoleResourcesMgrDao);
	}

	@Test
	public void findSysRoleResourcesTest() {
		SysRoleVO record = new SysRoleVO();
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(20);

		PagedResult<SysRoleVO> result = sysRolesMgrDao.findSysRoles(record, page);
		System.out.println("findSysRoles result:" + result);
	}

	@Test
	public void saveOrUPdateTest() {
		SysRoleVO record = new SysRoleVO();
		record.setRemark("JUnit Test Case ");
		record.setRolename("test1");
		record.setRoleCode("test1");
		record.setValidFlag(1);
		record.setId(1L);
		
		System.out.println(record);
		List<SysRoleVO> records=new ArrayList<SysRoleVO>();
		records.add(record);
		int result = sysRolesMgrDao.saveOrUpdate(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}

}
