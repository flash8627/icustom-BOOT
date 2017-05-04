package com.gwtjs.springsecurity;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.gwtjs.springsecurity.jaxrs.service.impl.RoleRestService;
import com.gwtjs.springsecurity.jaxrs.service.impl.UserRestService;

//@ApplicationPath("/")
public class ApplicationConfig extends Application {

    /*public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        // Add your resources.
        resources.add(UserRestService.class);
        resources.add(RoleRestService.class);

        // Add additional features such as support for Multipart.
        resources.add(MultiPartFeature.class);

        return resources;
    }*/
}
