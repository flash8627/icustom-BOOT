package com.gwtjs.icustom.springsecurity.api;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.core.log.ICustomLogger;
import com.gwtjs.core.log.ICustomLoggerFactory;

@SpringBootApplication 	
public class SecurityApiMainApplication {

	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(SecurityApiMainApplication.class);

	public static void main(String[] args) {
		new SpringApplication(SecurityApiMainApplication.class).run(args);
		log.info("Running with Spring successfull------");

	}
	
}