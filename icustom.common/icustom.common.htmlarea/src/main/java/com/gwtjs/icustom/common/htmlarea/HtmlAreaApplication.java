package com.gwtjs.icustom.common.htmlarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class HtmlAreaApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(HtmlAreaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HtmlAreaApplication.class, args);
		log.info("Running with Spring successfull------");
	}
	
}
