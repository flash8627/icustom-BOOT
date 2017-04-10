package com.gwtjs.icustom.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*public class RestJerseyConfig extends ResourceConfig{

 public JerseyConfig() {
 register(RequestContextFilter.class);
 //配置restful package.
 packages("com.gwtjs.icustom");
 }
 }*/

@Component
public class JerseyConfig extends ResourceConfig {
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new ServletContainer(), "/services/*");
		// our rest resources will be available in the path /rest/*
		registration.addInitParameter(
				ServletProperties.JAXRS_APPLICATION_CLASS,
				JerseyConfig.class.getName());
		return registration;
	}
	
	public JerseyConfig() {
		register(RequestContextFilter.class);
		//关闭wadl自动生成
		//property(ServerProperties.WADL_FEATURE_DISABLE, true);
		packages("com.gwtjs.icustom.simple.jaxrs.service.impl","com.gwtjs.icustom.simple.jaxrs.service");
	}
}
