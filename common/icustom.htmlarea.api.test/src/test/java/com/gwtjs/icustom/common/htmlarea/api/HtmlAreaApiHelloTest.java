package com.gwtjs.icustom.common.htmlarea.api;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class HtmlAreaApiHelloTest {

	@Before
	public void setUP() {
		// 指定 URL 和端口号
		RestAssured.baseURI = "http://localhost:8086/";
		RestAssured.port = 8086;
	}

	@Test
	public void testFindHtmlAreaPage() {
		given().contentType("application/json").when().get("services/htmlarea/htmlAreaService/findHtmlAreaPage/20/1").then().statusCode(200);
		given().param("pageSize", "8").when().get("services/htmlarea/htmlAreaService/findHtmlAreaPage/20/1").then().body("pageVO.pageSize", equalTo(20));
		/*given().auth().basic("admin", "dddddd").when().*/get("services/htmlarea/htmlAreaService/findHtmlAreaPage/20/1").then()/*.body("pageVO",is(12))*/;
		 //调用数组方法
		 /*get("/1220562").then()
		 //取顶级属性“title”
		 .body("title", equalTo("i-custom"))
		 //取下一层属性
		 .body("rating.max", equalTo(10)).body("tags.size()", is(8))
		 //取数组第一个对象的“name”属性
		 .body("tags[0].name", equalTo("i-custom"))
		 //判断数组元素
		 .body("author", hasItems("[日] i-custom"))*/;
		
	}

	@Test
	public void testSearchBook() {
		/*
		 * given().param("q", "java8").when().get("/search").then().body("count", equalTo(2));
		 * given().cookie("name", "xx").when().get("/xxx").then().body();
		given().header("name", "xx").when().get("/xxx").then().body();
		given().contentType("application/json").when().get("/xxx").then().body();*/
		/*given().auth().basic(username, password).when().get("/secured").then().statusCode(200);
		given().auth().oauth(..);
		given().auth().oauth2(..);*/

	}
	
	

}
