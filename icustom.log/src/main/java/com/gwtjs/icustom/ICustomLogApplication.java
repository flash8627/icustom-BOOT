package com.gwtjs.icustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomLogApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomLogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomLogApplication.class, args);
		log.info("Running with ICustom Log successfull------");
	}

}