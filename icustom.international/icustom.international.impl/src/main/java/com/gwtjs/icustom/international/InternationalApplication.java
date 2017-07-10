package com.gwtjs.icustom.international;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternationalApplication {
	
	private static final Logger log = LoggerFactory
			.getLogger(InternationalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(InternationalApplication.class, args);

		log.info("Running with Spring successfull------");

	}

}
