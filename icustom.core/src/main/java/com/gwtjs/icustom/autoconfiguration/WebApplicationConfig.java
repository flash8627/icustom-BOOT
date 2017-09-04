package com.gwtjs.icustom.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.gwtjs.icustom.filter.RequestContextFilter;
import com.gwtjs.icustom.filter.ResourcesFilter;
import com.gwtjs.icustom.filter.StampParameterDateFilter;

/**
 * web应用程序的配置，注册servlet，listener，filter等类。
 * 
 * @author aGuang 2017/06/23
 * 
 */
@Configuration 
@ConditionalOnClass(WebApplicationConfig.class)
@PropertySource("classpath:application.properties")
@ImportResource({ "classpath*:/config/*.configs.xml",
	"classpath*:/config/*.beans.xml",
	"classpath*:/config/*.service.xml",
	"classpath*:/config/*.services.xml",
	"classpath*:/config/*.exceptions.xml"})
//, "classpath*:spring.xml"
@ComponentScan({ "com.gwtjs.icustom.filter", "com.gwtjs.icustom.servlet",
	"com.gwtjs.icustom.autoconfiguration" })
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE - 1)
public class WebApplicationConfig implements EnvironmentAware {

	private Environment env;

	@Bean
	public IApplicationPrincipal applicationPrincipal(/*ICustomCoreProperties properties*/) {
		// 利用参数设置应用实例信息。
		Application application = new Application();
		application.setAppId(this.env.getProperty(EnvConstants.APPLICATION_ID));
		application.setAppName(this.env
				.getProperty(EnvConstants.APPLICATION_NAME));
		//application.setScope(properties.getScope());
		return application;
	}

	/**
	 * 注册资源拦截器
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(FilterRegistrationBean.class)
	public FilterRegistrationBean registerDispatchServlet() {
		FilterRegistrationBean registration = new FilterRegistrationBean(
				new ResourcesFilter());
		registration.setName("ICustomResourcesFilter");
		registration.addUrlPatterns("/*");
		// registration.setOrder(Ordered.HIGHEST_PRECEDENCE-1);//在最高优先级之后执行。
		// registration.setOrder(1000);
		return registration;
	}

	/**
	 * UTF-8编码过滤器。
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(FilterRegistrationBean.class)
	public FilterRegistrationBean characterEncodingFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(
				new CharacterEncodingFilter());
		registrationBean.setName("ICustomCharacterEncodingFilter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE - 1);// 在最高优先级之后执行。
		return registrationBean;
	}

	/**
	 * UTF-8编码过滤器。
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(FilterRegistrationBean.class)
	public FilterRegistrationBean stampParameterDateFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(
				new StampParameterDateFilter());
		registrationBean.setName("ICustomStampParameterDateFilter");
		registrationBean.addUrlPatterns("/*");
		//registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE - 1);// 在最高优先级之后执行。
		return registrationBean;
	}

	/**
	 * 注册dispatch-servlet
	 * 
	 * @return
	 */
	/*
	 * @Bean @ConditionalOnMissingBean(ICustomServletDispatcher.class) public
	 * ServletRegistrationBean registerDispatchServlet() {
	 * ServletRegistrationBean registration = new ServletRegistrationBean(new
	 * ICustomServletDispatcher());
	 * registration.setName("icustomDispatchServlet");
	 * registration.addUrlMappings("/servlet/*");
	 * registration.setLoadOnStartup(0); return registration; }
	 */

	/**
	 * 注册RequestContextFilter。
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(FilterRegistrationBean.class)
	public FilterRegistrationBean changeRequestContextFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(
				new RequestContextFilter());
		registration.setName("ICustomRequestContextFilter");// 避免与spring-boot默认的requestContextFilter冲突。
		registration.addUrlPatterns("/*");
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE - 1);
		return registration;
	}

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}

}
