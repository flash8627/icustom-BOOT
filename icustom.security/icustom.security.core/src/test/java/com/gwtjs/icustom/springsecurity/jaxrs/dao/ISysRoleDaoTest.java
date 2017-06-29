package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.MainApplicationTest;
import com.gwtjs.icustom.springsecurity.entity.SysRole;
import com.gwtjs.icustom.springsecurity.entity.SysUser;
import com.gwtjs.icustom.springsecurity.jaxrs.dao.ISysRoleDao;

public class ISysRoleDaoTest extends MainApplicationTest {
	
	@Autowired
	private ISysRoleDao sysRoleDao;
	
	@Test
	public void serviceAocTest()
	{
		assertTrue(sysRoleDao!=null);
	}
	
	@Test @Ignore
	public void insertTest()
	{
		Integer id = sysRoleDao.findRoleIdCount();
		SysRole role = new SysRole();
		role.setId(id);
		role.setRolename("site_test");
		role.setUserId(8);
		
		SysUser user = new SysUser();
		user.setId(8);
		role.setSysUser(user);
		
		sysRoleDao.insert(role);
	}
	
	@Test
	public void deleteTest()
	{
		SysRole role = new SysRole();
		role.setId(4);
		sysRoleDao.delete(role);
	}
	
	@Test
	public void updateTest()
	{
		SysRole role = new SysRole();
		role.setRolename("supuser");
		role.setId(3);
		sysRoleDao.update(role);
	}
	
	@Test
	public void findRolePageTest()
	{
		SysRole role = new SysRole();
		role.setRolename("user");
		
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(10);
		
		PagedResult<SysRole> result = sysRoleDao.findRolePage(role, page);
		System.out.println("role result:\n"+result);
		System.out.println("role page result:\n"+result.getPageVO());
		System.out.println("role VO   result:\n"+result.getResult());
	}
	
}
