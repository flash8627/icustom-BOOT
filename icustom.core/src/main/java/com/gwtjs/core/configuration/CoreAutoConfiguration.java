package com.gwtjs.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
* Created by aGuang on 2016/10/14.
*/
@Configuration
@ImportResource({"classpath*:/config/*.configs.xml","classpath*:/config/*.beans.xml","classpath*:/config/*.exceptions.xml","classpath*:applicationContext.xml"})//引入*.beans,*.exceptinos等配置。
@ComponentScan({"com.gwtjs.icustom.core"})
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE-1)//保持高优先级，避免被默认值给覆盖。
public class CoreAutoConfiguration implements EnvironmentAware {

	private Environment env;

	private static final Logger logger = LoggerFactory
			.getLogger(CoreAutoConfiguration.class);

	@Bean
	public CoreProperties coreProperties() {
		return new CoreProperties();
	}

	@Bean
	public IApplicationPrincipal applicationPrincipal(
			CoreProperties coreProperties) {
		// 利用参数设置应用实例信息。
		Application application = new Application();
		application.setAppId(this.env.getProperty(EnvConstants.APPLICATION_ID));
		application.setAppName(this.env
				.getProperty(EnvConstants.APPLICATION_NAME));
		application.setScope(coreProperties.getScope());
		return application;
	}

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}
}
