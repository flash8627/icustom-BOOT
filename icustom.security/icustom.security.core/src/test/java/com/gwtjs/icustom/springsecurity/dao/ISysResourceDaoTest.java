package com.gwtjs.icustom.springsecurity.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gwtjs.core.entity.PagedResult;
import com.gwtjs.core.entity.PageVO;
import com.gwtjs.icustom.springsecurity.SecurityMainApplicationTest;
import com.gwtjs.icustom.springsecurity.dao.ISysResourceDao;
import com.gwtjs.icustom.springsecurity.entity.SysResourceVO;

public class ISysResourceDaoTest  extends SecurityMainApplicationTest {

	@Autowired
	private ISysResourceDao sysResourceDao;

	@Test
	public void serviceAocTest() {
		assertTrue(sysResourceDao != null);
	}

	@Test @Ignore
	public void insertTest() {
		SysResourceVO sys=new SysResourceVO();
		int result = sysResourceDao.insert(sys);
		System.out.println(result);
	}

	@Test @Ignore
	public void updateTest() {
		SysResourceVO sys=new SysResourceVO();
		int result = sysResourceDao.update(sys);
		System.out.println(result);
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
