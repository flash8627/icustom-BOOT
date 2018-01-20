package com.gwtjs.icustom.api.test;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

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
		SpringApplication app = new SpringApplication(ApiTestUiMainApplication.class, args);
		app.run(args);
		log.info("Running with Spring successfull------");

	}
}