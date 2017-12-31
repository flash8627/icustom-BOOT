package com.gwtjs.icustom.security.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.security.SecurityImplMainApplication;
import com.gwtjs.icustom.springsecurity.entity.SysUserVO;

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
	
	@Test
	public void findUserRolesTest() {
		SysUserVO record = new SysUserVO();
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUserVO>result =  sysUserMgrDao.findUserByPage(record, page);
		System.out.println("findUserByPage result:"+result);
	}
	
	@Test
	public void saveOrUpdateTest() {
		/*SysUserVO record = new SysUserVO();
		record.setAccount("test1");
		record.setValidStart(null);
		record.setUsername("test1");
		record.setEmail("flash8627@hotmail.com");
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		record.setPassword(bc.encode("dddddd"));
		List<SysUserVO> records = new ArrayList<SysUserVO>();
		records.add(record);
		
		int result =  sysUserMgrDao.saveOrUpdate(records);
		System.out.println("findUserByPage result:"+result);*/
	}
	
}
