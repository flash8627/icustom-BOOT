package com.gwtjs.springsecurity.jaxrs.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.Order;

@Path("/orders")
@Service
@Produces(MediaType.APPLICATION_JSON)
public interface IOrdersServices {

	@POST
	@Path("Order")
	public ResultWrapper createOrder(Order order);

	@POST
	@Path("CreateOrderLineItem")
	public ResultWrapper createOrderLineItem(Order order);

	@PUT
	@Path("UpdateOrderLineItem")
	public ResultWrapper updateOrderLineItem(Order order);

	@DELETE
	@Path("DeleteOrderLineItem")
	public ResultWrapper deleteOrderLineItem(Order order);

	@POST
	@Path("InitializeOrder")
	public ResultWrapper initializeOrder(Order order);

	@GET
	@Path("GetOrders")
	public ResultWrapper getOrders(Order order);

	@GET
	@Path("GetOrder/{orderId}")
	public ResultWrapper getOrder(Integer orderId);

	@POST
	@Path("UpdateOrder")
	public ResultWrapper updateOrder(Order order);

}
