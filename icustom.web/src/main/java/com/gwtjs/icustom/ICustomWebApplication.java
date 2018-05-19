package com.gwtjs.icustom;


import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomWebApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomWebApplication.class);
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("spring.application.name", "icustom-web");
		//System.setProperties(props);
		SpringApplication.run(ICustomWebApplication.class, args);
		log.info("\nRunning with icustom web successfull------");
	}
	
}
