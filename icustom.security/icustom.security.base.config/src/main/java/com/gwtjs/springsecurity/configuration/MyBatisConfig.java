package com.gwtjs.springsecurity.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.gwtjs.core.intercepts.PageInterceptor;

/**
 * MyBatis基础配置
 * 
 * @author aGuang
 *
 */
@Configuration
@MapperScan("com.gwtjs.**.dao")
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		//PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("com.gwtjs.springsecurity.entity");
		
		PageInterceptor pageInterceptor = new PageInterceptor();

		// 添加分页拦截器插件
		sessionFactory.setPlugins(new Interceptor[] { pageInterceptor });

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			sessionFactory.setMapperLocations(resolver
					.getResources("classpath*:com/gwtjs/**/dao/*Dao.xml"));
			return sessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.mybatis.datasource")
	public DataSource dataSource(){
		return new DruidDataSource();
	}

	@Bean(name = "transactionManager")
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	/*D:\Workspaces\ICustom\spring-security_spring-boot\spring-boot-icustom\src\main\java\com\gwtjs\icustom\demo\SpringBootICustomApplication.java*/

}
