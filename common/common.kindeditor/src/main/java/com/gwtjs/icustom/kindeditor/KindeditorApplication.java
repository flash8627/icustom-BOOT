package com.gwtjs.icustom.kindeditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class KindeditorApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(KindeditorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KindeditorApplication.class, args);
		log.info("\nstartup successfull---");
	}
	
}
