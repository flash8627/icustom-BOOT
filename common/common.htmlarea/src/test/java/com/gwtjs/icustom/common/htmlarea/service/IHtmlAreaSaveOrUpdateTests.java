package com.gwtjs.icustom.common.htmlarea.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
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
import com.gwtjs.icustom.util.json.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HtmlAreaApplication.class)
public class IHtmlAreaSaveOrUpdateTests {

	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(IHtmlAreaSaveOrUpdateTests.class);

	@Inject
	private IHtmlAreaService htmlAreaService;

	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaService);
		log.info("htmlAreaService", htmlAreaService);
	}

	@Test
	public void testSaveOrUpdateHTML() {
		String content = "{\"name\":\"中文试一下\",\"title\":\"中文试一下\",\"mappingUrl\":\"fasdfasdf\",\"content\":\"asdfasdf中文试一下\",\"description\":\"中文试一下\",\"programFilterEnable\":true,\"category\":\"\",\"validFromDate\":\"2017-12-04\",\"validToDate\":\"2017-12-04\",\"htmlAreaId\":\"0\"}";
		HtmlAreaVO vo = (HtmlAreaVO) JsonUtil.getDTO(content, HtmlAreaVO.class);
		
		ResultWrapper result = htmlAreaService.saveOrUpdate(vo);
		log.info("saveOrUpdate result", result);
	}

}
