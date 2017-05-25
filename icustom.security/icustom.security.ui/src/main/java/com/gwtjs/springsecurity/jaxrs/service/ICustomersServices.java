package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.Customer;

@Path("/customers")
@Service
@Produces(MediaType.APPLICATION_JSON)
public interface ICustomersServices {

	@GET
	@Path("ImportCustomers")
	public ResultWrapper importCustomers();

	@GET
	@Path("GetCustomers")
	public ResultWrapper getCustomers(Customer customer);

	@POST
	@Path("CreateCustomer")
	public ResultWrapper createCustomer(Customer customer);

	@PUT
	@Path("UpdateCustomer")
	public ResultWrapper updateCustomer(Customer customer);

	@GET
	@Path("GetCustomer")
	public ResultWrapper getCustomer(Customer customer);

}
