package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.HttpStatusCode;
import com.gwtjs.springsecurity.entity.Product;
import com.gwtjs.springsecurity.jaxrs.service.IProductServices;

@Api("/products")
public class ProductServices implements IProductServices {

	@Override
	public ResultWrapper importProducts() {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getProduct(Integer productId) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper getProducts(Product product) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper createProduct(Product product) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	@Override
	public ResultWrapper updateProduct(Product product) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(HttpStatusCode.OK, null);
	}

	

}
