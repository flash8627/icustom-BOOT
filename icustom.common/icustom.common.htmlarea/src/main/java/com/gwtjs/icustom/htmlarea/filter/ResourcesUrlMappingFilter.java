package com.gwtjs.icustom.htmlarea.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;

/**
 * 拦截资源文件,将富文本的路径转换成管理平台编辑的内容
 * @author aGuang
 *
 */
@WebFilter(urlPatterns = "*",filterName="ResourcesUrlMappingFilter")
public class ResourcesUrlMappingFilter implements Filter{
	
	@Inject
	private IHtmlAreaService htmlAreaService;
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//htmlAreaService = (IHtmlAreaService) applicationContext.getBean("htmlAreaService");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("按路径取资源,如果有富文本则替换,没有则放行: "+htmlAreaService);
		System.out.println("按路径取资源,如果有富文本则替换,没有则放行: "+applicationContext);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
