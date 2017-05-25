package com.gwtjs.icustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ICustomWebApplication {
	
	private static final Logger log = LoggerFactory
			.getLogger(ICustomWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomWebApplication.class, args);
		log.info("Running with Spring successfull------");
	}
}
