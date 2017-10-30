package com.gwtjs.icustom.common.htmlarea.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwtjs.icustom.common.htmlarea.vo.HtmlAreaVO;
import com.gwtjs.icustom.entity.ResultWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IHtmlAreaServiceTests {
	
	@Inject
	private IHtmlAreaService htmlAreaService;
	
	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaService);
		System.out.println(htmlAreaService);
	}
	
	@Test
	public void testSaveOrUpdate()
	{
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		ResultWrapper result = htmlAreaService.saveOrUpdate(list);
		System.out.println(result);
	}

}
