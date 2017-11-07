package com.gwtjs.icustom.springsecurity.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.gwtjs.icustom.springsecurity.service.impl.ResourceRestService;
import com.gwtjs.icustom.springsecurity.service.impl.RoleRestService;
import com.gwtjs.icustom.springsecurity.service.impl.UserRestService;

@Component
public class SecurityCoreCxfConfig {
	
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
        beans.add(new UserRestService());
        beans.add(new RoleRestService());
        beans.add(new ResourceRestService());
        
        endpoint.setServiceBeans(beans);
        endpoint.setAddress("/security/core");
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        
        BindingFactoryManager manager=endpoint.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory factory=new JAXRSBindingFactory();
        factory.setBus(endpoint.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID,factory);
        return endpoint.create();
    }
    
}
