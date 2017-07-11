package com.gwtjs.icustom.springsecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecruityCoreMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("home.html");
    	registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/hello").setViewName("hello.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/admin").setViewName("admin.html");
        registry.addViewController("/error").setViewName("error.html");
        registry.addViewController("/accessDenied").setViewName("accessDenied.html");
    }

}
