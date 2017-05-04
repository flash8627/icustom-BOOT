package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/sayHello")
@Service
public interface HelloService {

    @GET
    @Path("/{a}")
    @Produces(MediaType.TEXT_PLAIN)
    String sayHello(@PathParam("a") String a);

}
