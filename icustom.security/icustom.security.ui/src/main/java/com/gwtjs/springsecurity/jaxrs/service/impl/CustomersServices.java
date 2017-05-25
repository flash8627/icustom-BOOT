package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.Customer;
import com.gwtjs.springsecurity.entity.HttpStatusCode;
import com.gwtjs.springsecurity.jaxrs.service.ICustomersServices;

@Api("/customers")
public class CustomersServices implements ICustomersServices {

	@Override
	public ResultWrapper importCustomers() {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getCustomers(Customer customer) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

}
