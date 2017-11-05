package com.gwtjs.icustom.common.htmlarea.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.gwtjs.icustom.common.htmlarea.filter.ResourcesUrlMappingFilter;

@Component @Configuration 
@ConditionalOnClass(HtmlAreaWebConfig.class)
@ComponentScan({ "com.gwtjs.icustom.common.htmlarea.filter" })
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE - 1)
public class HtmlAreaWebConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	/**
	 * 注册资源拦截器
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(FilterRegistrationBean.class)
	public FilterRegistrationBean registerDispatchServlet() {
		FilterRegistrationBean registration = new FilterRegistrationBean(
				new ResourcesUrlMappingFilter());
		registration.setName("ResourcesUrlMappingFilter");
		registration.addUrlPatterns("/*");
		// registration.setOrder(Ordered.HIGHEST_PRECEDENCE-1);//在最高优先级之后执行。
		// registration.setOrder(1000);
		return registration;
	}
}
