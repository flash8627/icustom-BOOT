package com.gwtjs.icustom.attachments;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomAttachmentsApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(ICustomAttachmentsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomAttachmentsApplication.class, args);
		log.info("ICustom SpringBoot Start Success...");
	}
	
}
