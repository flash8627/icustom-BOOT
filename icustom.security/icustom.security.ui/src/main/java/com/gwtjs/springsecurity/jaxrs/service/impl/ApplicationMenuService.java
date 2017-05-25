package com.gwtjs.springsecurity.jaxrs.service.impl;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

import com.gwtjs.core.entity.ResultWrapper;
import com.gwtjs.springsecurity.entity.SysResource;
import com.gwtjs.springsecurity.jaxrs.service.IApplicationMenuService;

@Api("/sys")
public class ApplicationMenuService implements IApplicationMenuService {

	@Override
	public List<SysResource> initializeApplication() {
		int i = 1;
		List<SysResource> menuItem = new ArrayList<>();
		menuItem.add(new SysResource(i++, "Home", "#Main/Home", "Main", false,
				1));
		menuItem.add(new SysResource(i++, "About", "#Main/About", "Main",
				false, 2));
		menuItem.add(new SysResource(i++, "Register", "#Accounts/Register",
				"Main", false, 3));
		menuItem.add(new SysResource(i++, "Login", "#Accounts/Login", "Main",
				false, 4));
		menuItem.add(new SysResource(i++, "Customers",
				"#Customers/CustomerInquiry", "Main", true, 1));
		menuItem.add(new SysResource(i++, "Orders",
				"#Orders/OrderEntryCustomerInquiry", "Main", true, 2));
		menuItem.add(new SysResource(i++, "Products",
				"#Products/ProductInquiry", "Main", true, 3));
		menuItem.add(new SysResource(i++, "My Account", "#Accounts/MyAccount",
				"Main", true, 4));
		menuItem.add(new SysResource(i++, "Logout", "#Accounts/Logout", "Main",
				true, 5));
		menuItem.add(new SysResource(i++, "Home", "#Main/Home", "Main", true, 6));
		menuItem.add(new SysResource(i++, "About", "#Main/About", "Main", true,
				7));
		menuItem.add(new SysResource(i++, "Customer Inquiry",
				"#Customers/CustomerInquiry", "Customers", true, 1));
		menuItem.add(new SysResource(i++, "Customer Maintenance",
				"#Customers/CustomerMaintenance", "Customers", true, 2));
		menuItem.add(new SysResource(i++, "Import Customer Test Data",
				"#Customers/ImportCustomers", "Customers", true, 3));
		menuItem.add(new SysResource(i++, "Order Entry",
				"#Orders/OrderEntryCustomerInquiry", "Orders", true, 1));
		menuItem.add(new SysResource(i++, "Order Inquiry",
				"#Orders/OrderInquiry", "Orders", true, 2));
		menuItem.add(new SysResource(i++, "Product Inquiry",
				"#Products/ProductInquiry", "Products", true, 1));
		menuItem.add(new SysResource(i++, "Product Maintenance",
				"#Products/ProductMaintenance", "Products", true, 2));
		menuItem.add(new SysResource(i++, "Import Product Test Data",
				"#Products/ImportProducts", "Products", true, 4));
		return menuItem;
	}

	/**
	 * 返回类型参考:C:\Users\aGuang\Desktop\current doc\CodeProjectAngularJSSource\AngularJSWebApplication\WebApiControllers
	 */
	@Override
	public ResultWrapper authenicateUser(String route) {
		// TODO Auto-generated method stub
		return ResultWrapper.constructSuccessResult(route, route);
	}

}
