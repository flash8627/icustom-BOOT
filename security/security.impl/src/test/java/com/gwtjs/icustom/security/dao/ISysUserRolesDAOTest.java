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
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;
import com.gwtjs.icustom.springsecurity.entity.SysUserRoleVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SecurityImplMainApplication.class)
public class ISysUserRolesDAOTest {
	
	@Inject
	private ISysUserMgrDao sysUserMgrDao;
	@Inject
	private ISysRolesMgrDao sysRolesMgrDao;
	@Inject
	private ISysUserRolesMgrDao sysUserRolesMgrDao;
	
	@Test
	public void contextLoads() {
		assertNotNull(sysRolesMgrDao);
		System.out.println(sysRolesMgrDao);
		assertNotNull(sysUserMgrDao);
		System.out.println(sysUserMgrDao);
		assertNotNull(sysUserRolesMgrDao);
		System.out.println(sysUserRolesMgrDao);
	}
	
	/**
	 * 查询用户的角色
	 */
	@Test
	public void findUserRolesTest() {
		long userId = 1l;
		List<SysRoleVO> result =  sysUserRolesMgrDao.findByUserRoles(userId);
		System.out.println("findByUserRoles result:"+result);
	}
	
	/**
	 * 保存用户的角色
	 */
	@Test
	public void saveOrUpdateTest() {
		SysUserRoleVO record = new SysUserRoleVO();
		List<SysUserRoleVO> records=new ArrayList<SysUserRoleVO>();
		records.add(record);
		int result = sysUserRolesMgrDao.saveOrUpdate(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}
	
	/**
	 * 删除用户的角色
	 */
	@Test
	public void deleteUserRolesTest() {
		long userId = 4;
		int result = sysUserRolesMgrDao.removeRoleResources(userId);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}
	
	/**
	 * 删除用户的角色
	 */
	@Test
	public void batchRemovePksTest() {
		SysUserRoleVO record = new SysUserRoleVO();
		List<SysUserRoleVO> records=new ArrayList<SysUserRoleVO>();
		records.add(record);
		int result = sysUserRolesMgrDao.batchRemovePks(records);
		System.out.println("findAuthResourcesTreeRoot result:" + result);
	}
	
}
