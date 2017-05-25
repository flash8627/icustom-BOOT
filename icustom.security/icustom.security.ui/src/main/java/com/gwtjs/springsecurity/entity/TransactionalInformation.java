package com.gwtjs.springsecurity.entity;

import java.io.Serializable;

public class TransactionalInformation implements Serializable {

	private boolean isAuthenicated;

	public boolean isAuthenicated() {
		return isAuthenicated;
	}

	public void setAuthenicated(boolean isAuthenicated) {
		this.isAuthenicated = isAuthenicated;
	}

}
