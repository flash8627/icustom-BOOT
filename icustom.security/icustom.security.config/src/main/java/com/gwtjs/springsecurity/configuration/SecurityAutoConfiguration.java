package com.gwtjs.springsecurity.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gwtjs.springsecurity.support.MyFilterSecurityInterceptor;

/**
 * web应用程序的配置，注册security的拦截器
 * @author aGuang 2017/06/23 
 * 
 */
@Configuration
@ConditionalOnClass(SecurityAutoConfiguration.class)
@ComponentScan({"com.gwtjs.springsecurity.support"})
public class SecurityAutoConfiguration {
	
	/**
     * 注册资源拦截器
     * @return
     */
    @Bean @ConditionalOnMissingBean(FilterRegistrationBean.class)
    public FilterRegistrationBean registerDispatchServlet() {
    	FilterRegistrationBean registration = new FilterRegistrationBean(new MyFilterSecurityInterceptor());
    	registration.setName("MyFilterSecurityInterceptor");
        registration.addUrlPatterns("/*");
        //registration.setOrder(Ordered.HIGHEST_PRECEDENCE-1);//在最高优先级之后执行。
        //registration.setOrder(1000);
        return registration;
    }
	
}
