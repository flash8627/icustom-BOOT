package com.gwtjs.icustom.common.htmlarea.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.htmlarea.HtmlAreaApplication;
import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.htmlarea.vo.HtmlAreaVO;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HtmlAreaApplication.class)
public class IHtmlAreaSearchServiceTests {

	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(IHtmlAreaSearchServiceTests.class);

	@Inject
	private IHtmlAreaService htmlAreaService;

	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaService);
		log.info("htmlAreaService", htmlAreaService);
	}

	@Test @Ignore
	public void testFindHtmlAreaMapping() {
		String mappingUrl = "/";
		HtmlAreaVO result = htmlAreaService.findHtmlAreaByMappingUrl(mappingUrl);
		log.info("findHtmlArea result," + result);
	}
	
	/**
	 * 分页测试
	 */
	@Test @Ignore
	public void testFindHtmlAreaPage() {
		HtmlAreaVO vo = new HtmlAreaVO();
		PageVO page = new PageVO();
		page.setCurPage(3);
		page.setPageSize(2);
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo, page);
		log.info("findHtmlAreaPage result," + result);
	}
	
	/**
	 * 分页测试
	 */
	@Test @Ignore
	public void testFindHtmlAreaPageLikeMapUrl() {
		HtmlAreaVO vo = new HtmlAreaVO();
		vo.setName("Test");
		vo.setTitle("主站");
		vo.setMappingUrl("resources/");
		vo.setDescription("Test");
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo, page);
		log.info("findHtmlAreaPage result," + result);
	}
	
	/**
	 * 分页测试
	 */
	@Test @Ignore
	public void testFindHtmlAreaPageLikeContent() {
		HtmlAreaVO vo = new HtmlAreaVO();
		vo.setContent("adfasdfasdf");
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo, page);
		log.info("findHtmlAreaPage result," + result);
	}
	
	/**
	 * 分页测试,从什么时间到什么时间测试
	 */
	@Test
	public void testFindHtmlAreaPageDateSearch() {
		HtmlAreaVO vo = new HtmlAreaVO();
		try {
			/*Date createFromDate = DateUtil.stringToDate("2017-05-25");
			Date createdToDate = DateUtil.stringToDate("2017-12-25");*/
			vo.setFromDate("2017-05-25");
			vo.setToDate("2017-12-25");
		}catch (Exception e) {
			e.printStackTrace();
		}
		PageVO page = new PageVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo, page);
		log.info("\ntestFindHtmlAreaPageDateSearch result," + result);
	}

}
