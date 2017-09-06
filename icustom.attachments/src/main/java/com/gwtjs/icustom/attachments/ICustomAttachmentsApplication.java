package com.gwtjs.icustom.attachments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.gwtjs.icustom.attachments.servlet.UploadServlet;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomAttachmentsApplication {

	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomAttachmentsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ICustomAttachmentsApplication.class, args);
		log.info("ICustom SpringBoot Start Success...");
	}

	@Bean
	@ConditionalOnMissingBean(UploadServlet.class)
	public ServletRegistrationBean uploadServletDispatch() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new UploadServlet());
		registration.setName("upload");
		registration.addUrlMappings("/upload");
		registration.setLoadOnStartup(0);
		return registration;
	}
	
	@Bean
	@ConditionalOnMissingBean(UploadServlet.class)
	public ServletRegistrationBean progressServletDispatch() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new UploadServlet());
		registration.setName("uploadProgress");
		registration.addUrlMappings("/uploadProgress/getProgressBar");
		registration.setLoadOnStartup(0);
		return registration;
	}

}
