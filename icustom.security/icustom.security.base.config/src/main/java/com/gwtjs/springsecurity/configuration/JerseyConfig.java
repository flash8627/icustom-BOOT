package com.gwtjs.springsecurity.configuration;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gwtjs.springsecurity.entity.SysRole;

/*public class RestJerseyConfig extends ResourceConfig{

 public JerseyConfig() {
 register(RequestContextFilter.class);
 //配置restful package.
 packages("com.gwtjs.icustom");
 }
 }*/

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new ServletContainer(), "/api/*");
		// our rest resources will be available in the path /rest/*
		registration.addInitParameter(
				ServletProperties.JAXRS_APPLICATION_CLASS,
				JerseyConfig.class.getName());
		/*registration.setInitParameters(
				"jersey.config.server.provider.classnames",
				"org.glassfish.jersey.media.multipart.MultiPartFeature");*/
		return registration;
	}

	public JerseyConfig() {
		register(RequestContextFilter.class);
		// 关闭wadl自动生成
		// property(ServerProperties.WADL_FEATURE_DISABLE, true);
		packages("com.gwtjs.springsecurity.jaxrs.service",
				"com.gwtjs.springsecurity.jaxrs.service.impl");

		register(MultiPartFeature.class);
	}

	/*public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<Class<?>>();

		// Add your resources.
		resources.add(SysRole.class);

		// Add additional features such as support for Multipart.
		resources.add(MultiPartFeature.class);

		return resources;
	}*/
}
