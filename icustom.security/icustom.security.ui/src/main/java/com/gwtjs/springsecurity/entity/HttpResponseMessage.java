package com.gwtjs.springsecurity.entity;

import java.util.List;

public class HttpResponseMessage {
	
	private boolean returnStatus;

	private String returnMessage;

	private boolean isAuthenicated;

	private List<ApplicationMenu> menuItems;

	public boolean isReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public boolean isAuthenicated() {
		return isAuthenicated;
	}

	public void setAuthenicated(boolean isAuthenicated) {
		this.isAuthenicated = isAuthenicated;
	}

	public List<ApplicationMenu> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<ApplicationMenu> menuItems) {
		this.menuItems = menuItems;
	}
	
	
	
}
