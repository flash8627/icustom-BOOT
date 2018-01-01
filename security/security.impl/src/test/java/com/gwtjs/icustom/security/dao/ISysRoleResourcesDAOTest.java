package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.springsecurity.entity.SysRoleResourceVO;

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
	
	/**
	 * 角色能访问的资源
	 */
	@Test
	public void findSysRoleResourcesTest() {
		long roleId=1l;
		List<SysRoleResourceVO>result = sysRoleResourcesMgrDao.findByRoleResource(roleId);
		System.out.println("findSysRoles result:" + result);
	}
	
	/**
	 * 保存角色的资源
	 */
	@Test
	public void saveOrUpdateTest() {
		/*SysRoleVO record = new SysRoleVO();
		record.setRemark("JUnit Test Case ");
		record.setRolename("test1");
		record.setRoleCode("test1");
		record.setValidFlag(1);
		record.setId(1L);
		
		System.out.println(record);
		List<SysRoleVO> records=new ArrayList<SysRoleVO>();
		records.add(record);
		int result = sysRolesMgrDao.saveOrUpdate(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);*/
	}
	
	/**
	 * 删除角色的资源
	 */
	@Test
	public void deleteRoleResourcesTest() {
		
	}

}
