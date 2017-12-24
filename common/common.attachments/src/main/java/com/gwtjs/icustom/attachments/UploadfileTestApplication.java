package com.gwtjs.icustom.attachments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;

import com.gwtjs.icustom.attachments.resolver.CustomMultipartResolver;

@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})

@Configuration
@ComponentScan(basePackages = {"com.gwtjs.icustom.attachments"})
@ServletComponentScan(basePackages = {"com.gwtjs.icustom.attachments"})
@SpringBootApplication
public class UploadfileTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadfileTestApplication.class, args);
	}
	
	/*
	 * 将 multipartResolver 指向我们刚刚创建好的继承 CommonsMultipartResolver 类的自定义文件上传处理类
	 */
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
	    CustomMultipartResolver customMultipartResolver = new CustomMultipartResolver();
	    return customMultipartResolver;
	}
	
}
