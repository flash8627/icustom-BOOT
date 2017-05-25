package com.gwtjs.core.api.test;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 	
public class ApiTestUiMainApplication {

	private static final Logger log = LoggerFactory
			.getLogger(ApiTestUiMainApplication.class);

	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Spring profile(s) : {}");
	}

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		SpringApplication app = new SpringApplication(ApiTestUiMainApplication.class);
		app.run(args);
		log.info("Running with Spring successfull------");

	}
}