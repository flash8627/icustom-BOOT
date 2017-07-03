package com.gwtjs.icustom.springsecurity.jaxrs.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.SecurityMainApplicationTest;
import com.gwtjs.icustom.springsecurity.dao.ISysUserDao;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

public class ISysUserDaoTest extends SecurityMainApplicationTest {
	
	@Autowired
	private ISysUserDao sysUserDao;
	
	@Test
	public void serviceAocTest()
	{
		System.out.println(sysUserDao);
	}
	
	@Test
	public void findUserBynameTest()
	{
		String name = "admin";
		SysUserVO user = sysUserDao.findByUsername(name);
		System.out.println(user);
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserPageTest()
	{
		SysUserVO user = new SysUserVO();
		//user.setName("d3g");
		//user.setEmail("flash8627@hotmail.com");
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(12);
		page.setMysqlStartIndex(0);
		page.setMysqlEndIndex(8);
		PagedResult<SysUserVO> result = sysUserDao.findUserPage(user, page);
		System.out.println("PagedResult:"+result);
		System.out.println("PagedResult page:"+result.getPageVO());
		System.out.println("PagedResult vo:"+result.getResult());
		assertTrue(user!=null);
	}
	
	@Test
	public void findUserTest()
	{
		SysUserVO user = sysUserDao.findUser(1);
		System.out.println(user);
		assertTrue(user!=null);
	}
	
	@Test @Ignore
	public void batchInsertTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		List<SysUserVO> list = new ArrayList<>();
		SysUserVO user = new SysUserVO();
		user.setUsername("dzg");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		//user.setSRoles(SysRoles);
		list.add(user);
		sysUserDao.saveUsers(list);
	}
	
	@Test @Ignore
	public void insertTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		SysUserVO user = new SysUserVO();
		user.setAccount("dzg");
		user.setUsername("dzg");
		user.setEmail("8538191@qq.com");
		user.setPassword(bc.encode("dddddd"));
		//user.setSRoles(SysRoles);
		//sysUserDao.saveUsers(user);
	}
	
	@Test @Ignore
	public void updatePwdTest()
	{
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		SysUserVO user = new SysUserVO();
		user.setId(1);
		String password = bc.encode("dddddd");
		user.setPassword(password);
		//user.setSRoles(SysRoles);
		sysUserDao.updatePwd(user);
	}
	
	@Test @Ignore
	public void updateTest()
	{
		SysUserVO user = new SysUserVO();
		user.setId(2);
		user.setAccount("dzg");
		user.setUsername("dzg");
		user.setEmail("8538191@qq.com");
		//user.setSRoles(SysRoles);
		//sysUserDao.update(user);
	}
	
}
