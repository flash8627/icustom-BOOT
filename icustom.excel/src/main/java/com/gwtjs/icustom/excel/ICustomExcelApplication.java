package com.gwtjs.icustom.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.gwtjs.icustom.log.ICustomLogger;
//import com.gwtjs.icustom.log.ICustomLoggerFactory;


@SpringBootApplication
public class ICustomExcelApplication {
	
	//private static final ICustomLogger log = ICustomLoggerFactory.getLogger(ICustomExcelApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomExcelApplication.class, args);
		//log.info("ICustom SpringBoot Start Success...");
	}
	
}
