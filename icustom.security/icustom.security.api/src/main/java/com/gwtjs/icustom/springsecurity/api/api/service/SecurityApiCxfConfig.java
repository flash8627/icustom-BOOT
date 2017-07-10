package com.gwtjs.icustom.springsecurity.api.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.gwtjs.icustom.springsecurity.api.api.service.impl.ResourceService;

@Component
public class SecurityApiCxfConfig {
	
	@Autowired
    private Bus bus;

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
        endpoint.setProvider(jaxbProvider);
        endpoint.setBus(bus);
        
        /*添加cxf服务,相当于以前的xml的配置-jaxrs:serviceBeans*/
        List<Object> beans=new ArrayList<>();
        beans.add(new ResourceService());
        
        endpoint.setServiceBeans(beans);
        endpoint.setAddress("/pub");
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }
    
}
