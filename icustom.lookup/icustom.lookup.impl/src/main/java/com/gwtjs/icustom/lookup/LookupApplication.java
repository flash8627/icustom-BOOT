package com.gwtjs.icustom.lookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LookupApplication {
	
	private static final Logger log = LoggerFactory
			.getLogger(LookupApplication.class);
	
	public static void main(String[] args) {

		SpringApplication.run(LookupApplication.class, args);

		log.info("Running with Spring successfull------");

	}

}
