package com.gwtjs.icustom.common.htmlarea.api;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class HtmlAreaApiHelloTest {

	@Before
	public void setUP() {
		// 指定 URL 和端口号
		RestAssured.baseURI = "http://localhost:8086/";
		RestAssured.port = 8086;
		RestAssured.basePath = "/services/htmlarea";

	}

	/**
	 * /{pageSize}/{curPage}
	 */
	@Test
	public void testFindHtmlAreaPagePathParam() {
		given().contentType("application/json").when()
				.get("/htmlAreaService/findHtmlAreaPage/{pageSize}/{curPage}", 20, 1).then().statusCode(200);
		given().get("/htmlAreaService/findHtmlAreaPage/20/1").then().body("pageVO.pageSize", equalTo(20));

	}

	/**
	 * queryParam
	 */
	@Test
	public void testFindHtmlAreaPageLike() {
		given().queryParam("title", "A11111111A").queryParam("name", "1AAAA211111A").when()
				.get("/htmlAreaService/findHtmlAreaPage/{pageSize}/{curPage}", 20, 1).then()
				.contentType("application/json").statusCode(200);
		given().get("/htmlAreaService/findHtmlAreaPage/20/1").then().body("pageVO.pageSize", equalTo(20));

	}

	@Test
	public void testFindHtmlAreaPage() {
		given().headers("Accept", "application/json", "Content-Type", "application/json").when()
				.get("/htmlAreaService/findHtmlAreaPage/20/1").then().statusCode(200);
		given().headers("Accept", "application/json", "Content-Type", "application/json").param("pageSize", "8").when()
				.get("/htmlAreaService/findHtmlAreaPage/20/1").then().body("pageVO.pageSize", equalTo(20));
		/* given().auth().basic("admin", "dddddd").when(). */
		get("/htmlAreaService/findHtmlAreaPage/20/1").then().body("pageVO.pageSize", is(20));
	}

	@Test
	public void testSaveOrUpdateHtmlArea() {
		/*given().parameters("name", "中文试一下", "title", "中文试一下", "mappingUrl", "fasdfasdf",
				"content", "asdfasdf中文试一下", "description", "中文试一下", "validFromDate", "2017-12-04").expect().statusCode(500).when()
				.post("/saveOrUpdate");*/
		final String bodyString = "{\"name\":\"中文试一下\",\"title\":\"中文试一下\",\"mappingUrl\":\"fasdfasdf\",\"content\":\"asdfasdf中文试一下\",\"description\":\"中文试一下\",\"programFilterEnable\":true,\"category\":\"\",\"validFromDate\":\"2017-12-04\",\"validToDate\":\"2017-12-04\",\"htmlAreaId\":\"0\"}";
		   
	    given().
	    contentType("application/json").
	    request().body(bodyString).
	    expect().
	      statusCode(200).
	      body(
	    		  "status", is(1),/*
	      "order.deleteDate", is(nullValue()),*/
	      "success", equalTo(true)).
	    when().
	    post("/saveOrUpdate");

	}

	/**
	 * given().headers("Accept", "application/json", "Content-Type",
	 * "application/json")
	 */
	@Test
	public void testSearchContentType() {
		// 验证 index 的值不大于 20
		given().headers("Accept", "application/json", "Content-Type", "application/json")
				.get("/htmlAreaService/findHtmlAreaPage/20/1").then().assertThat()
				.body("pageVO.curPage", lessThanOrEqualTo(20));

		// 数组的 size 为12
		given().contentType("application/json").get("/htmlAreaService/findHtmlAreaPage/20/1").then().assertThat()
				.body("result", hasSize(12));

		// 验证 result 中每个元素的 htmlAreaId 属性值都大于 0
		given().contentType("application/json").get("/htmlAreaService/findHtmlAreaPage/20/1").then().assertThat()
				.body("result.htmlAreaId", everyItem(greaterThan(0)));

		/*
		 * given().param("q", "java8").when().get("/search").then().body("count",
		 * equalTo(2)); given().cookie("name", "xx").when().get("/xxx").then().body();
		 * given().header("name", "xx").when().get("/xxx").then().body();
		 * given().contentType("application/json").when().get("/xxx").then().body();
		 */
		/*
		 * given().auth().basic(username,
		 * password).when().get("/secured").then().statusCode(200);
		 * given().auth().oauth(..); given().auth().oauth2(..);
		 */

	}

}
