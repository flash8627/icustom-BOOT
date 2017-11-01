package com.gwtjs.icustom.common.htmlarea.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.common.htmlarea.vo.HtmlAreaVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IHtmlAreaDaoTests {
	
	@Inject
	private IHtmlAreaDao htmlAreaDao;
	
	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaDao);
		System.out.println(htmlAreaDao);
	}
	
	@Test
	public void testSaveOrUpdate()
	{
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		int result = htmlAreaDao.saveOrUpdate(list);
		System.out.println(result);
	}
}
