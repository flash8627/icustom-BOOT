package com.gwtjs.icustom.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.springsecurity.support.Appctx;

@SpringBootApplication 	
public class SecurityImplMainApplication {

	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(SecurityImplMainApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecurityImplMainApplication.class);
		Appctx.ctx = app.run(args);

		log.info("Running with Spring successfull------");

	}
	
}