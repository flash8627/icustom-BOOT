package com.gwtjs.core.filter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.core.util.spring.StringUtils;

/**
 * js和css增加时间戳
 * @author aGuang
 *
 */
@WebFilter(urlPatterns = "/*",filterName="StampParameterDateFilter")
public class StampParameterDateFilter implements Filter {
	
	private String stampStatus = "1";
	
	private static final com.gwtjs.core.log.ICustomLogger log = com.gwtjs.core.log.ICustomLoggerFactory
			.getLogger(StampParameterDateFilter.class);
	
	private static final Logger logger = LoggerFactory
			.getLogger(StampParameterDateFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("stamp Status",stampStatus);
		//logger.error(stampStatus);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		String requestURL = req.getRequestURL().toString();
		String queryStr = req.getQueryString();
		System.out.println("----------requestURL --"+requestURL);
		System.out.println("----------requestURI --"+uri);
		/*System.out.println("----------- queryStr --"+queryStr);
		
		System.out.println("-----------     URI:"+getRequestTime(uri));
		System.out.println(" LastFileUpdateTime:"+getLastFileUpdateTime("1"));*/
		// add timestamp to static resource, to avoid cache
		if (requestURL != null
				&& (requestURL.endsWith(".js") || requestURL.endsWith(".css"))) { // static resource
			String newURL = null;
			System.out.println("is js or css");
			/*如果已经加了时间戳*/
			if (StringUtils.isNotBlank(queryStr)
					&& queryStr.trim().indexOf(ParameterConfig.STATIC_TAIL) == -1) {
				newURL = requestURL + "?" + queryStr + "&"
						+ ParameterConfig.STATIC_TAIL + new Date().getTime();
				System.out.println("-----------已经加了时间戳-"+newURL);
				logger.error(newURL.toString());
				resp.sendRedirect(newURL);
				//chain.doFilter(request, response);
			}
			if (StringUtils.isBlank(queryStr)) {
				newURL = requestURL + "?" + ParameterConfig.STATIC_TAIL
						+ new Date().getTime();
				System.out.println("-----------直接增加时间戳-"+newURL);
				resp.sendRedirect(newURL);
				//chain.doFilter(request, response);
			}
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 以文件最后修改时间为时间戳
	 * @param file
	 * @return
	 */
	private String getRequestTime(String url)
	{
		String sample = "?";
		int len = url.indexOf("?");
		if(len>-1){
			sample = "&";
		}
		
		return url + sample + ParameterConfig.STATIC_TAIL
				+ new Date().getTime();
	}
	
	/**
	 * 以文件最后修改时间为时间戳
	 * @param file
	 * @return
	 */
	private String getLastFileUpdateTime(String file)
	{
		Date when=new Date();
		
		if(file!=null && !"".equals(file)){
			File f=new File(file);
			long timestamp=f.lastModified();
			when=new Date(timestamp);
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssS");
		return sdf.format(when);
	}

}
