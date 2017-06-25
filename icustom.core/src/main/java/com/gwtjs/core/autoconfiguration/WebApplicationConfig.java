package com.gwtjs.core.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.gwtjs.core.filter.RequestContextFilter;
import com.gwtjs.core.filter.ResourcesFilter;

/**
 * web应用程序的配置，注册servlet，listener，filter等类。
 * @author aGuang 2017/06/23 
 * 
 */
@Configuration
@ConditionalOnClass(WebApplicationConfig.class)
@ComponentScan({"com.gwtjs.core.filter","com.gwtjs.core.servlet","com.gwtjs.core.autoconfiguration"})
public class WebApplicationConfig {
	
    /**
     * 注册资源拦截器
     * @return
     */
    @Bean @ConditionalOnMissingBean(FilterRegistrationBean.class)
    public FilterRegistrationBean registerDispatchServlet() {
    	FilterRegistrationBean registration = new FilterRegistrationBean(new ResourcesFilter());
    	registration.setName("ICustomResourcesFilter");
        registration.addUrlPatterns("/*");
        //registration.setOrder(Ordered.HIGHEST_PRECEDENCE-1);//在最高优先级之后执行。
        //registration.setOrder(1000);
        return registration;
    }

    /**
     * UTF-8编码过滤器。
     * @return
     */
    @Bean @ConditionalOnMissingBean(FilterRegistrationBean.class)
    public FilterRegistrationBean characterEncodingFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CharacterEncodingFilter());
        registrationBean.setName("ICustomCharacterEncodingFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE-1);//在最高优先级之后执行。
        return  registrationBean;
    }


    /**
     * 注册dispatch-servlet
     * @return
     */
    /*@Bean  @ConditionalOnMissingBean(ICustomServletDispatcher.class)
    public ServletRegistrationBean registerDispatchServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ICustomServletDispatcher());
        registration.setName("icustomDispatchServlet");
        registration.addUrlMappings("/servlet/*");
        registration.setLoadOnStartup(0);
        return registration;
    }*/
    
    /**
     * 注册RequestContextFilter。
     * @return
     */
    @Bean @ConditionalOnMissingBean(FilterRegistrationBean.class)
    public FilterRegistrationBean changeRequestContextFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new RequestContextFilter());
        registration.setName("ICustomRequestContextFilter");//避免与spring-boot默认的requestContextFilter冲突。
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE-1);
        return registration;
    }


}
