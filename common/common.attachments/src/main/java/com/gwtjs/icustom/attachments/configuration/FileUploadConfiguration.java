package com.gwtjs.icustom.attachments.configuration;

import java.io.IOException;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gwtjs.icustom.attachments.resolver.CustomMultipartResolver;

/**
 * 文件上传配置
 * 
 * @author a g
 * @create 2017年1月11日
 */
@Configuration
@ConditionalOnClass({ Servlet.class, CustomMultipartResolver.class, MultipartConfigElement.class })
@ConditionalOnProperty(prefix = "spring.http.multipart", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(MultipartProperties.class)
public class FileUploadConfiguration {

	@Bean @ConditionalOnMissingBean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置文件大小限制 ,超出设置页面会抛出异常信息，
		// 这样在文件上传的地方就需要进行异常信息的处理了;
		factory.setMaxFileSize(1024L * 1024L); // KB,MB
		/// 设置总上传数据总大小
		// factory.setMaxRequestSize("512000MB");
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}

	// 配置multipart解析器
	// 具体参数的配置在AbstractAnnotationConfigDispatcherServletInitializer的方法
	// customizeRegistration(Dynamic registration)方法或web.xml中设置

	/*@Bean("multipartResolver")
    @ConditionalOnMissingBean(CustomMultipartResolver.class)
	public CustomMultipartResolver multipartResolver() throws IOException {
		CustomMultipartResolver resolver = new CustomMultipartResolver();
		resolver.setMaxUploadSize(2000000000000000000L);
		return resolver;
	}*/

}
