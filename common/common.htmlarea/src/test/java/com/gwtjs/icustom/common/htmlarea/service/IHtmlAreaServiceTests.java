package com.gwtjs.icustom.common.htmlarea.service;

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
import com.gwtjs.icustom.entity.ResultWrapper;
import com.gwtjs.icustom.htmlarea.HtmlAreaApplication;
import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HtmlAreaApplication.class)
public class IHtmlAreaServiceTests {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(IHtmlAreaServiceTests.class);
	
	@Inject
	private IHtmlAreaService htmlAreaService;
	
	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaService);
		log.info("htmlAreaService",htmlAreaService);
	}
	
	@Test
	public void testSaveOrUpdate()
	{
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		ResultWrapper result = htmlAreaService.saveOrUpdate(list);
		log.info("saveOrUpdate result",result);
	}
	
	@Test
	public void testFindHtmlArea()
	{
		Integer htmlAreaId = 0;
		HtmlAreaVO result = htmlAreaService.findHtmlArea(htmlAreaId);
		log.info("findHtmlArea result,"+result);
	}
	
	@Test
	public void testFindHtmlAreaPage()
	{
		HtmlAreaVO vo=new HtmlAreaVO();PageVO page = new PageVO();
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo,page);
		log.info("findHtmlAreaPage result,"+result);
	}
	
	@Test
	public void testBatchRemovePks()
	{
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		ResultWrapper result = htmlAreaService.batchRemovePks(list);
		log.info("batchRemovePks result,"+result);
	}
	
	@Test
	public void testFindAll()
	{
		List<HtmlAreaVO> list = htmlAreaService.findAll();
		log.info("batchRemovePks findAll,"+list);
	}

}
