/*
 */

package com.gwtjs.icustom.bbs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
public class ICustomBBSApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomBBSApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomBBSApplication.class, args);
		log.info("Running with Spring successfull------");
	}
	
}


