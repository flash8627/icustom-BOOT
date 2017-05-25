package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.HttpStatusCode;
import com.gwtjs.springsecurity.entity.Order;
import com.gwtjs.springsecurity.jaxrs.service.IOrdersServices;

@Api("/orders")
public class OrdersServices implements IOrdersServices {

	@Override
	public ResultWrapper createOrder(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper createOrderLineItem(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper updateOrderLineItem(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper deleteOrderLineItem(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper initializeOrder(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getOrders(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getOrder(Integer order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper updateOrder(Order order) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

}
