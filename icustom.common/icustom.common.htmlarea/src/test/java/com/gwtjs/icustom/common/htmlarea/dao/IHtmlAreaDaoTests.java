package com.gwtjs.icustom.common.htmlarea.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.htmlarea.dao.IHtmlAreaDao;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;

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
	
	@Test
	public void testFindHtmlArea()
	{
		Integer htmlAreaId = 0;
		HtmlAreaVO result = htmlAreaDao.findHtmlArea(htmlAreaId);
		System.out.println(result);
	}
	
	@Test
	public void testFindHtmlAreaPage()
	{
		HtmlAreaVO vo=new HtmlAreaVO();PageVO page = new PageVO();
		PagedResult<HtmlAreaVO> result = htmlAreaDao.findHtmlAreaPage(vo,page);
		System.out.println(result);
	}
	
	@Test
	public void testBatchRemovePks()
	{
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		int result = htmlAreaDao.batchRemovePks(list);
		System.out.println(result);
	}
	
	@Test
	public void testFindAll()
	{
		List<HtmlAreaVO> list = htmlAreaDao.findAll();
		System.out.println(list);
	}
	
}
