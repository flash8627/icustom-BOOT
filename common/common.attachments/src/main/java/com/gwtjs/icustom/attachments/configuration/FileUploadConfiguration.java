package com.gwtjs.icustom.attachments.configuration;

import java.io.IOException;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import com.gwtjs.icustom.attachments.resolver.CustomMultipartResolver;

/**
 * 文件上传配置
 * 
 * @author a g
 * @create 2017年1月11日
 */
public class FileUploadConfiguration {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置文件大小限制 ,超出设置页面会抛出异常信息，
		// 这样在文件上传的地方就需要进行异常信息的处理了;
		factory.setMaxFileSize("25600KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("512000KB");
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}
	
	//配置multipart解析器
    //具体参数的配置在AbstractAnnotationConfigDispatcherServletInitializer的方法
    //customizeRegistration(Dynamic registration)方法或web.xml中设置
    
    @Bean("multipartResolver")
    public CustomMultipartResolver  multipartResolver() throws IOException{
    	CustomMultipartResolver resolver = new CustomMultipartResolver();
    	//resolver.setMaxUploadSize(200000000);
        return resolver;
    }
    
}
