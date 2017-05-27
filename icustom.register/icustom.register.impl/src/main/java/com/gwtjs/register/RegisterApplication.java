package com.gwtjs.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegisterApplication {
	
	private static final Logger log = LoggerFactory
			.getLogger(RegisterApplication.class);
	
	public static void main(String[] args) {

		// SpringApplication.run(MainApplication.class, args);
		SpringApplication.run(RegisterApplication.class, args);

		log.info("Running with Spring successfull------");

	}

}
