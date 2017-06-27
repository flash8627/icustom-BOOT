package com.gwtjs.icustom;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.core.log.ICustomLogger;
import com.gwtjs.core.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomWebApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomWebApplication.class, args);
		log.info("Running with icustom web successfull------");
	}
	
}
