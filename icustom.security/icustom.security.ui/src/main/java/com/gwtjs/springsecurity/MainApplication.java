package com.gwtjs.springsecurity;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 	
public class MainApplication {

	private static final Logger log = LoggerFactory
			.getLogger(MainApplication.class);

	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Spring profile(s) : {}");
	}

	public static void main(String[] args) {
		
		// SpringApplication.run(MainApplication.class, args);
		SpringApplication app = new SpringApplication(MainApplication.class);
		app.run(args);
		log.info("Running with Spring successfull------");

	}
}