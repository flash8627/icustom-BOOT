package com.gwtjs.icustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ICustomUtilApplication {
	
	protected static Logger logger = LoggerFactory.getLogger(ICustomUtilApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ICustomUtilApplication.class, args);
		logger.info("ICustom SpringBoot Start Success");
	}
	
}
