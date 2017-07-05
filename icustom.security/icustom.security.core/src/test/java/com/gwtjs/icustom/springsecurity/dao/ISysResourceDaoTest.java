package com.gwtjs.icustom.springsecurity.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.core.entity.PageVO;
import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.icustom.springsecurity.SecurityMainApplicationTest;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

public class ISysResourceDaoTest  extends SecurityMainApplicationTest {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Test @Ignore
	public void serviceAocTest() {
		assertTrue(sysResourceDao != null);
	}

	@Test
	public void saveOrUpdateTest() {
		List<SysResourceVO> list = new ArrayList<SysResourceVO>();
		
		SysResourceVO sys=new SysResourceVO();
		sys.setCreatedUser(0);
		sys.setUpdateLastUser(0);
		sys.setResourceName("test");
		sys.setResourceUrl("/test");
		sys.setMethodName("test");
		sys.setMethodPath("/test");
		sys.setRemark("junit test");
		list.add(sys);
		sysResourceDao.saveOrUpdate(list);
	}

	@Test
	public void findAllTest() {
		List<SysResourceVO> list = sysResourceDao.findAll();
		System.out.println(list);
	}

	@Test
	public void findResourcePageTest() {
		SysResourceVO sys = new SysResourceVO();
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(18);
		PagedResult<SysResourceVO> result = sysResourceDao.findResourcePage(sys,
				page);
		System.out.println("resource result:\n"+result);
		System.out.println("resource page result:\n"+result.getPageVO());
		System.out.println("resource VO   result:\n"+result.getResult());
	}

}
