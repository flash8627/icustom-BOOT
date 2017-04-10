package com.gwtjs.springsecurity;

/*import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
/*SpringBoot之Mapper接口文件所在的包名,mybaits dao.xml的扫描路径*/
//@MapperScan("com.gwtjs.**.dao")
/*加载spring资源文件*/
//@ImportResource({"classpath:applicationContext.xml"})
/*SpringBoot之Servlet、Filter、Listener配置*/
//@ServletComponentScan(value={"com.gwtjs.**.filter","com.gwtjs.*.servlet"})
public class SpringSecurityApplication  extends SpringBootServletInitializer{
	
	protected static Logger logger = LoggerFactory.getLogger(SpringSecurityApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSecurityApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		logger.info("ICustom SpringBoot Start Success");
	}
	
}
