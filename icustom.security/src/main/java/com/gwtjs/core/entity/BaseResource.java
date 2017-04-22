package com.gwtjs.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统基础属性
 * 
 * @author aGuang
 *
 */
public class BaseResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5402317918334633979L;
	private long createdUser;
	private Date createdDate;
	private String nameCn;

	private long updateLastUser;
	private Date updateLastDate;
	private String lastNameCn;
	private String language;

	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String attribute6;
	private String attribute7;
	private String attribute8;
	private String attribute9;
	private String attribute10;

	private Integer orderCode;
	
	private Integer validFlag;

	public BaseResource() {
		super();
	}

	public BaseResource(long createdUser, Date createdDate,
			long updateLastUser, Date updateLastDate, String language,
			Integer orderCode) {
		super();
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateLastUser = updateLastUser;
		this.updateLastDate = updateLastDate;
		this.language = language;
		this.orderCode = orderCode;
	}

	public long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(long createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getUpdateLastUser() {
		return updateLastUser;
	}

	public void setUpdateLastUser(long updateLastUser) {
		this.updateLastUser = updateLastUser;
	}

	public Date getUpdateLastDate() {
		return updateLastDate;
	}

	public void setUpdateLastDate(Date updateLastDate) {
		this.updateLastDate = updateLastDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getLastNameCn() {
		return lastNameCn;
	}

	public void setLastNameCn(String lastNameCn) {
		this.lastNameCn = lastNameCn;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

}
