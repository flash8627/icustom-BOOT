package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.SecurityMainApplicationTest;
import com.gwtjs.icustom.springsecurity.dao.ISysRoleDao;
import com.gwtjs.icustom.springsecurity.entity.SysRoleVO;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

public class ISysRoleDaoTest extends SecurityMainApplicationTest {
	
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
		/*Integer id = sysRoleDao.findRoleIdCount();
		SysRoleVO role = new SysRoleVO();
		role.setId(id);
		role.setRolename("site_test");
		
		SysUserVO user = new SysUserVO();
		user.setId(8);
		
		sysRoleDao.insert(role);*/
	}
	
	@Test
	public void deleteTest()
	{
		/*SysRoleVO role = new SysRoleVO();
		role.setId(4);
		sysRoleDao.delete(role);*/
	}
	
	@Test
	public void updateTest()
	{
		/*SysRoleVO role = new SysRoleVO();
		role.setRolename("supuser");
		role.setId(3);
		sysRoleDao.update(role);*/
	}
	
	@Test
	public void findRolePageTest()
	{
		SysRoleVO role = new SysRoleVO();
		role.setRolename("user");
		
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(10);
		
		PagedResult<SysRoleVO> result = sysRoleDao.findRolePage(role, page);
		System.out.println("role result:\n"+result);
		System.out.println("role page result:\n"+result.getPageVO());
		System.out.println("role VO   result:\n"+result.getResult());
	}
	
}
