package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
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
		SysRoleResourceVO record = new SysRoleResourceVO();
		List<SysRoleResourceVO> records=new ArrayList<SysRoleResourceVO>();
		records.add(record);
		
		int result = sysRoleResourcesMgrDao.saveOrUpdate(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}
	
	/**
	 * 删除角色的资源
	 */
	@Test
	public void deleteRoleResourcesTest() {
		long roleId = 4l;
		sysRoleResourcesMgrDao.removeRoleResources(roleId);
	}
	
	/**
	 * 删除用户的角色
	 */
	@Test
	public void batchRemovePksTest() {
		SysRoleResourceVO record = new SysRoleResourceVO();
		List<SysRoleResourceVO> records=new ArrayList<SysRoleResourceVO>();
		records.add(record);
		int result = sysRoleResourcesMgrDao.batchRemovePks(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}

}
