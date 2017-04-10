package com.gwtjs.icustom.simple.jaxrs.service;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/hello2")
@Component
public interface IRestHelloWorldService {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public Map<String,Object> hello();
	
}
