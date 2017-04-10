package com.gwtjs.core;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.gwtjs.core.intercepts.PageInterceptor;
import com.gwtjs.core.intercepts.ProgramInterceptor;

@SpringBootApplication
/*SpringBoot之Mapper接口文件所在的包名,mybaits dao.xml的扫描路径*/
@MapperScan("com.gwtjs.**.dao")
/*加载spring资源文件*/
//@ImportResource({"classpath:applicationContext.xml"})
/*SpringBoot之Servlet、Filter、Listener配置*/
@ServletComponentScan(value={"com.gwtjs.**.filter","com.gwtjs.*.servlet"})
public class SpringBootICustomApplication {
	
	protected static Logger logger = LoggerFactory.getLogger(SpringBootICustomApplication.class);

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		PageInterceptor pageInterceptor = new PageInterceptor();
		ProgramInterceptor program = new ProgramInterceptor();
		
		sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor,program});
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		/*Mapper的xml文件存在位置,应该外部属性文件配置*/
		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources("classpath:com/gwtjs/**/dao/*Dao.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootICustomApplication.class, args);
		logger.info("ICustom SpringBoot Start Success");
	}
	
}
