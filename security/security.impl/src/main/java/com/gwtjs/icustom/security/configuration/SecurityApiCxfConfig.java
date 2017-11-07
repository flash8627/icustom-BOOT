package com.gwtjs.icustom.security.configuration;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gwtjs.icustom.security.services.ISysResourcesService;
import com.gwtjs.icustom.security.services.impl.SysResourcesService;


@Configuration
public class SecurityApiCxfConfig {
	
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    
    @Bean
    public ISysResourcesService sysResourcesService() {
        return new SysResourcesService();
    }
    
    /*@Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), sysResourcesService());
        endpoint.publish("/user");
        //增加拦截器endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }*/
    
}
