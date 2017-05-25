package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.Product;

@Path("/products")
@Service
@Produces(MediaType.APPLICATION_JSON)
public interface IProductServices {

	@PUT
	@Path("ImportProducts")
	public ResultWrapper importProducts();

	@GET
	@Path("GetProduct/{productId}")
	public ResultWrapper getProduct(Integer productId);

	@GET
	@Path("GetProducts")
	public ResultWrapper getProducts(Product product);

	@POST
	@Path("CreateProduct")
	public ResultWrapper createProduct(Product product);

	@PUT
	@Path("UpdateProduct")
	public ResultWrapper updateProduct(Product product);

}
