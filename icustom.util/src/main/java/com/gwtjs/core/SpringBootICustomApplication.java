package com.gwtjs.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootICustomApplication {
	
	protected static Logger logger = LoggerFactory.getLogger(SpringBootICustomApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootICustomApplication.class, args);
		logger.info("ICustom SpringBoot Start Success");
	}
	
}
