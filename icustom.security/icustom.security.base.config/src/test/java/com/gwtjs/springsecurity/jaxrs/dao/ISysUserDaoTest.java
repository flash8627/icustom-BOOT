package com.gwtjs.springsecurity.jaxrs.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gwtjs.core.entity.PagerVO;
import com.gwtjs.springsecurity.MainApplicationTest;
import com.gwtjs.springsecurity.entity.SysUser;

public class ISysUserDaoTest extends MainApplicationTest {
	
	@Autowired
	private ISysUserDao sysUserDao;
	
	@Test
	public void serviceAocTest()
	{
		System.out.println(sysUserDao);
	}
	
	@Test
	public void userCountIdTest()
	{
		int idCount = sysUserDao.findUserIdCount();
		assertTrue(idCount>0);
	}
	
	@Test
	public void findUserBynameTest()
	{
		String name = "dzg";
		SysUser user = sysUserDao.findUserByname(name);
		System.out.println(user);
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserPageTest()
	{
		SysUser user = new SysUser();
		//user.setName("d3g");
		//user.setEmail("flash8627@hotmail.com");
		PagerVO page = new PagerVO();
		page.setCurPage(1);
		page.setPageSize(12);
		page.setMysqlStartIndex(0);
		page.setMysqlEndIndex(8);
		List<SysUser> list = sysUserDao.findUserList(user, page);
		System.out.println("page:"+list);
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserTest()
	{
		SysUser user = sysUserDao.findUser(8);
		System.out.println(user);
		assertTrue(user!=null);
	}
	
	@Test @Ignore
	public void batchInsertTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		int idCount = sysUserDao.findUserIdCount();
		List<SysUser> list = new ArrayList<>();
		SysUser user = new SysUser();
		user.setId(idCount);
		user.setName("dzg");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		//user.setSRoles(SysRoles);
		list.add(user);
		sysUserDao.batchInsert(list);
	}
	
	@Test @Ignore
	public void insertTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		int idCount = sysUserDao.findUserIdCount();
		SysUser user = new SysUser();
		user.setId(idCount);
		user.setName("d3g");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		user.setDob(new Date());
		//user.setSRoles(SysRoles);
		sysUserDao.insert(user);
	}
	
	@Test
	public void updateTest()
	{
		//BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		SysUser user = new SysUser();
		user.setId(8);
		user.setName("d8g");
		user.setEmail("8538191@qq.com");
		//user.setPassword(bc.encode("dddddd"));
		user.setDob(new Date());
		//user.setSRoles(SysRoles);
		sysUserDao.update(user);
	}
	
	@Test
	public void findUserList()
	{
		List<SysUser> list = sysUserDao.findAllUserList();
		System.out.println(list);
	}
	
}
