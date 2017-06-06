package com.gwtjs.core.api.test;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.core.log.ICustomLogger;
import com.gwtjs.core.log.ICustomLoggerFactory;

@SpringBootApplication 	
public class ApiTestUiMainApplication {

	private static final ICustomLogger log = ICustomLoggerFactory
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