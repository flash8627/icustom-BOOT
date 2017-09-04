package com.gwtjs.icustom;

import org.junit.Test;

public class UtilTest {

	@Test
	public void pathTest() {
		String uri = "";
		String fileName = "";
		int num = -1;
		boolean flag = false;
		
		/*uri = "/resources/images/product-1.jpg";
		num = uri.lastIndexOf(".html");flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.lastIndexOf("."));
		System.out.println(uri+"::"+flag);

		uri = "/";flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.length() - 1);
		num = uri.lastIndexOf("/");
		System.out.println(fileName.equals("/") + ":" + num);System.out.println(uri+"::"+flag);

		uri = "/resources/css/ui.css";flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.lastIndexOf("."));
		System.out.println(uri+"::"+flag);

		uri = "/resources/jquery/jquery.min.js";flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.lastIndexOf("."));
		System.out.println(uri+"::"+flag);

		uri = "lookup/index.html";flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.lastIndexOf("."));
		System.out.println(uri+"::"+flag);

		uri = "/lookup/index.html";flag = suffixMatcher(uri);
		fileName = uri.substring(0, uri.lastIndexOf("."));
		System.out.println(uri+"::"+flag);

		uri = "/services/sys/resourcesService/findResourcesSiteMenu";
		if (uri.lastIndexOf(".") != -1)
			fileName = uri.substring(0, uri.lastIndexOf("."));
		flag = suffixMatcher(uri);
		System.out.println(uri+flag);*/

		uri = "http://localhost:8080/resources/fonts/fontawesome-webfont.woff2?v=4.5.0";
		flag = suffixMatcher2(uri);
		System.out.println(uri+flag);
		uri = "http://localhost:8080/resources/fonts/fontawesome-webfont.css?v=4.5.0";
		flag = suffixMatcher2(uri);
		System.out.println(uri+flag);
		uri = "http://localhost:8080/resources/fonts/fontawesome-webfont.css";
		flag = suffixMatcher2(uri);
		System.out.println(uri+flag);
		
		uri = "http://localhost:8080/resources/fonts/fontawesome-webfont.js?v=4.5.0";
		flag = suffixMatcher2(uri);
		if(flag){
			String[] urls = uri.split("[?]");
			if(urls.length>1){
				uri=uri+"&"+111;
			}else{
				uri=uri+"?"+111;
			}
			System.out.println("length:"+urls.length+uri+"+++"+flag);
		}
		uri = "/resources/fonts/fontawesome-webfont.css?v=4.5.0";
		flag = suffixMatcher2(uri);
		if(flag){
			String[] urls = uri.split("[?]");
			if(urls.length>1){
				uri=uri+"&"+111;
			}else{
				uri=uri+"?"+111;
			}
			System.out.println("length:"+urls.length+uri+"+++"+flag);
		}
		uri = "http://localhost:8080/resources/fonts/fontawesome-webfont.js";
		flag = suffixMatcher2(uri);
		
		if(flag){
			String[] urls = uri.split("[?]");
			if(urls.length>1){
				uri=uri+"&"+111;
			}else{
				uri=uri+"?"+111;
			}
			System.out.println("length:"+urls.length+uri+"+++"+flag);
		}
	}
	
	private boolean suffixMatcher2(String uri/* ,String suffix */) {
		if (uri.lastIndexOf(".js") != -1)
			return true;
		else if (uri.lastIndexOf(".css") != -1)
			return true;
		else
			return false;
	}
	
	private boolean suffixMatcher(String uri/* ,String suffix */) {
		if (uri.lastIndexOf(".html") != -1)
			return true;
		else if (uri.lastIndexOf(".htm") != -1)
			return true;
		else if (uri.lastIndexOf("/") == 0){
			System.out.println(uri+":::"+uri.lastIndexOf("/"));
			return true;
			
		}else
			return false;
	}

}
