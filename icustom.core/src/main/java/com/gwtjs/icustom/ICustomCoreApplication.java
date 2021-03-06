package com.gwtjs.icustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@SpringBootApplication
/*SpringBoot之Mapper接口文件所在的包名,mybaits dao.xml的扫描路径*/
//@MapperScan("com.gwtjs.**.dao")
/*加载spring资源文件*/
//@ImportResource({"classpath:applicationContext.xml"})
/*SpringBoot之Servlet、Filter、Listener配置*/
@ServletComponentScan(value={"com.gwtjs.icustom"})
public class ICustomCoreApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(ICustomCoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ICustomCoreApplication.class, args);
		log.info("ICustom Core Start Success...");
	}
	
}
