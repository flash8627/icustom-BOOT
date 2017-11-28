package com.gwtjs.icustom.htmlarea.configuration;

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
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.gwtjs.icustom.htmlarea.service.IHtmlAreaService;
import com.gwtjs.icustom.htmlarea.service.impl.HtmlAreaService;

@Component
public class HtmlAreaCxfConfig {
	
	/*@Autowired
    private Bus bus;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
    public Server rsServer() {
		IHtmlAreaService htmlAreaService = (IHtmlAreaService) applicationContext.getBean("htmlAreaService");
        System.out.println("HtmlAreaService:"+ htmlAreaService);
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
        endpoint.setProvider(jaxbProvider);
        endpoint.setBus(bus);
        
        //添加cxf服务,相当于以前的xml的配置-jaxrs:serviceBeans
        List<Object> beans=new ArrayList<>();
        beans.add(new HtmlAreaService());
        
        endpoint.setServiceBeans(beans);
        endpoint.setAddress("/htmlarea");
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        
        BindingFactoryManager manager=endpoint.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory factory=new JAXRSBindingFactory();
        factory.setBus(endpoint.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID,factory);
        return endpoint.create();
    }*/
}
