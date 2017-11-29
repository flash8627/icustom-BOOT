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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HtmlAreaApplication.class)
public class IHtmlAreaServiceTests {

	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(IHtmlAreaServiceTests.class);

	@Inject
	private IHtmlAreaService htmlAreaService;

	@Test
	public void contextLoads() {
		assertNotNull(htmlAreaService);
		log.info("htmlAreaService", htmlAreaService);
	}

	@Test
	public void testSaveOrUpdateHTML() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		String content = "<h2>\r\n" + 
				"	sadfasdfasdf\r\n" + 
				"</h2>\r\n" + 
				"<p>\r\n" + 
				"	fffffffffffffffffffff\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"	<br />\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"	<span style=\"font-size:16px;\"><strong>asdfasdf</strong></span><span style=\"font-size:16px;\"><strong></strong></span>\r\n" + 
				"</p>";
		vo.setContent(content);
		vo.setMappingUrl("resources/web/resources/js/menu.html");
		vo.setTitle("菜单模块");
		vo.setName("Test Html");
		vo.setCategory("category");
		vo.setDescription("Test Html");
		vo.setCreateFromDate(new Date());
		vo.setCreateToDate(new Date());
		list.add(vo);
		
		ResultWrapper result = htmlAreaService.batchSaveOrUpdate(list);
		log.info("saveOrUpdate result", result);
	}

	@Test
	public void testSaveOrUpdateJS() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		String content = "/**\r\n" + 
				" * \r\n" + 
				" */\r\n" + 
				"\r\n" + 
				"$(function() {\r\n" + 
				"	/*var now = new Date();\r\n" + 
				"	var list2 = [{link:\"#\",css:\"fa-spotify\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-tumblr\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-share-alt\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-linkedin\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-delicious\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-instagram\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-dropbox\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-soundcloud\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-pinterest\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-google-plus\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-github-alt\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-skype\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-stumbleupon\"},\r\n" + 
				"                 {link:\"#\",css:\"fa-youtube\"}];\r\n" + 
				"	var html = TemplateUtil.renderHtml('sys_footer_image2_link', {\r\n" + 
				"        data: list2\r\n" + 
				"    });\r\n" + 
				"	$('#footer_layout1').html(html);\r\n" + 
				"	\r\n" + 
				"	var linkList2 = [{link:\"#\",img:\"resources/images/card-2.png\"},\r\n" + 
				"		             {link:\"#\",img:\"resources/images/card-3.png\"},\r\n" + 
				"		             {link:\"#\",img:\"resources/images/card-4.png\"},\r\n" + 
				"		             {link:\"#\",img:\"resources/images/card-5.png\"}];\r\n" + 
				"	var html2 = TemplateUtil.renderHtml('sys_footer_image2_link', {\r\n" + 
				"        data: linkList2\r\n" + 
				"    });\r\n" + 
				"	$('#footer_link2').html(html2);*/\r\n" + 
				"	\r\n" + 
				"	/*$.ajax({ url: \"inc/footer.html\", context: null, success: function(resp){\r\n" + 
				"		\r\n" + 
				"		console.warn('source',source);\r\n" + 
				"		return ;\r\n" + 
				"	    var template = Handlebars.compile(source);\r\n" + 
				"	    \r\n" + 
				"	    var context = {title: \"标题\", body: \"我是字符串!\"}\r\n" + 
				"	    var html    = template(context);\r\n" + 
				"		$('body').last().append(resp);\r\n" + 
				"		\r\n" + 
				"	}});*///$('body').last().load(\"inc/footer.html\");\r\n" + 
				"})\r\n";
		vo.setContent(content);
		vo.setMappingUrl("resources/js/footer.js");
		vo.setTitle("主站底部动画js脚本");
		vo.setName("Test javascript");
		vo.setCategory("category");
		vo.setDescription("Test javascript");
		vo.setCreateFromDate(new Date());
		vo.setCreateToDate(new Date());
		list.add(vo);
		
		ResultWrapper result = htmlAreaService.batchSaveOrUpdate(list);
		log.info("saveOrUpdate result", result);
	}

	@Test
	public void testSaveOrUpdateCSS() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		String content = "/* MENU */\r\n" + 
				"\r\n" + 
				"#nav {\r\n" + 
				" background: #e5e5e5;\r\n" + 
				" float: left;\r\n" + 
				" margin: 0; padding: 0;\r\n" + 
				" border-bottom: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li a, #nav li {\r\n" + 
				" float: left;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li {\r\n" + 
				" list-style: none;\r\n" + 
				" position: relative;\r\n" + 
				" z-index: 1000;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li a {\r\n" + 
				" padding: 1em 2em;\r\n" + 
				" text-decoration: none;\r\n" + 
				" color: white;\r\n" + 
				" background: #556278;\r\n" + 
				" border-right: 1px solid #616e7f;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li a:hover {\r\n" + 
				"	color:#72cdc8;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"/* Submenu */\r\n" + 
				"\r\n" + 
				".hasChildren {\r\n" + 
				"	position: absolute;\r\n" + 
				"	width: 5px; height: 5px;\r\n" + 
				"	background: black;\r\n" + 
				"	right : 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li ul {\r\n" + 
				" display: none;\r\n" + 
				" position: absolute;\r\n" + 
				" left: 0;\r\n" + 
				" top: 100%;\r\n" + 
				" padding: 0; margin: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li:hover > ul {\r\n" + 
				" display: block;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li ul li, #nav li ul li a {\r\n" + 
				" float: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li ul li {\r\n" + 
				" _display: inline; /* for IE6 */\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li ul li a {\r\n" + 
				" width: 150px;\r\n" + 
				" display: block;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* SUBSUB Menu */\r\n" + 
				"\r\n" + 
				"#nav li ul li ul {\r\n" + 
				" display: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#nav li ul li:hover ul {\r\n" + 
				" left: 100%;\r\n" + 
				" top: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"#nav li ul li {\r\n" + 
				"	background: #556278;\r\n" + 
				"	border-bottom: 1px solid #72cdc8;\r\n" + 
				" border-right: 1px solid #72cdc8;\r\n" + 
				"}";
		vo.setContent(content);
		vo.setMappingUrl("resources/css/menu.css");
		vo.setTitle("主站菜单CSS");
		vo.setName("Test CSS");
		vo.setCategory("category");
		vo.setDescription("Test CSS");
		vo.setCreateFromDate(new Date());
		vo.setCreateToDate(new Date());
		list.add(vo);
		
		ResultWrapper result = htmlAreaService.batchSaveOrUpdate(list);
		log.info("saveOrUpdate result", result);
	}

	@Test
	public void testSaveOrUpdateSQL() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		String content = ";/*我来测一下sql注入*/select * from SYS_HTML_AREA_T t;--";
		vo.setContent(content);
		vo.setMappingUrl("insql");
		vo.setTitle("我来测一下sql注入攻击");
		vo.setName("我来测一下sql注入攻击");
		vo.setCategory("category");
		vo.setDescription("我来测一下sql注入攻击,如果content把sql脚本原样保存了，证明攻击无效。");
		vo.setCreateFromDate(new Date());
		vo.setCreateToDate(new Date());
		list.add(vo);
		
		ResultWrapper result = htmlAreaService.batchSaveOrUpdate(list);
		log.info("saveOrUpdate result", result);
	}

	@Test
	public void testSaveOrUpdateSerial() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		String content = System.currentTimeMillis()+"测试序列保存";
		vo.setContent(content);
		vo.setMappingUrl(System.currentTimeMillis()+"");
		vo.setTitle(System.currentTimeMillis()+"");
		vo.setName(System.currentTimeMillis()+"");
		vo.setCategory(System.currentTimeMillis()+"category");
		vo.setDescription(System.currentTimeMillis()+"测试序列保存,疯狂的保存");
		vo.setCreateFromDate(new Date());
		vo.setCreateToDate(new Date());
		list.add(vo);
		
		ResultWrapper result = htmlAreaService.batchSaveOrUpdate(list);
		log.info("saveOrUpdate result"+result.getObj());
	}

	@Test
	public void testFindHtmlArea() {
		Integer htmlAreaId = 2;
		HtmlAreaVO result = htmlAreaService.findHtmlArea(htmlAreaId);
		log.info("findHtmlArea result," + result);
	}

	@Test
	public void testFindHtmlAreaPage() {
		HtmlAreaVO vo = new HtmlAreaVO();
		PageVO page = new PageVO();
		PagedResult<HtmlAreaVO> result = htmlAreaService.findHtmlAreaPage(vo, page);
		log.info("findHtmlAreaPage result," + result);
	}

	@Test
	public void testBatchRemovePks() {
		List<HtmlAreaVO> list = new ArrayList<HtmlAreaVO>();
		HtmlAreaVO vo = new HtmlAreaVO();
		vo.setHtmlAreaId(21);
		list.add(vo);
		vo = new HtmlAreaVO();
		vo.setHtmlAreaId(16);
		list.add(vo);
		ResultWrapper result = htmlAreaService.batchRemovePks(list);
		log.info("batchRemovePks result," + result);
	}

	@Test
	public void testFindAll() {
		List<HtmlAreaVO> list = htmlAreaService.findAll();
		log.info("batchRemovePks findAll," + list);
	}

}
