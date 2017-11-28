package com.gwtjs.icustom.htmlarea.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gwtjs.icustom.entity.BaseResource;

/**
 * 公共功能-富文本-VO
 * 
 * @author aGuang
 *
 */
@JsonIgnoreProperties({ "category", "name", "description", "title", "mappingUrl", "attr1", "attr2", "attr3", "content",
		"secondLevelType", "thirdLevelType" })
public class HtmlAreaVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6970590248287107679L;

	public HtmlAreaVO() {
	}

	/** 富文本类型 **/
	private String category;
	/** 名称 **/
	private String name;
	/** 描述 **/
	private String description;
	/** 内容 **/
	private String content;
	/** 标题 **/
	private String title;
	/** 映射URL **/
	private String mappingUrl;
	/** 属性1 **/
	private String attr1;
	/** 属性2 **/
	private String attr2;
	/** 属性3 **/
	private String attr3;
	/** 账号 **/
	private String account;
	/** 一级类型 **/
	private String secondLevelType;
	/** 二级类型 **/
	private String thirdLevelType;
	/** 修建日期-结束日期 */
	private Date createToDate;
	/** 创建日期-开始时间 */
	private Date createFromDate;
	/**
	 * 是否启用了富文本的program过滤
	 * 
	 * @since 2017-10-07
	 */
	private boolean programFilterEnable;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMappingUrl() {
		return mappingUrl;
	}

	public void setMappingUrl(String mappingUrl) {
		this.mappingUrl = mappingUrl;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSecondLevelType() {
		return secondLevelType;
	}

	public void setSecondLevelType(String secondLevelType) {
		this.secondLevelType = secondLevelType;
	}

	public String getThirdLevelType() {
		return thirdLevelType;
	}

	public void setThirdLevelType(String thirdLevelType) {
		this.thirdLevelType = thirdLevelType;
	}

	public boolean isProgramFilterEnable() {
		return programFilterEnable;
	}

	public void setProgramFilterEnable(boolean programFilterEnable) {
		this.programFilterEnable = programFilterEnable;
	}

	public Date getCreateToDate() {
		return createToDate;
	}

	public void setCreateToDate(Date createToDate) {
		this.createToDate = createToDate;
	}

	public Date getCreateFromDate() {
		return createFromDate;
	}

	public void setCreateFromDate(Date createFromDate) {
		this.createFromDate = createFromDate;
	}

	@Override
	public String toString() {
		return "{'category':'" + category + "', 'name':'" + name + "', 'description':'" + description + "', 'content':'"
				+ content + "', 'title':'" + title + "', 'mappingUrl':'" + mappingUrl + "', 'attr1':'" + attr1 + "', 'attr2':'" + attr2
				+ "', 'attr3':'" + attr3 + "', 'account':'" + account + "', 'secondLevelType':'" + secondLevelType
				+ "', 'thirdLevelType':'" + thirdLevelType + "', 'createToDate':'" + createToDate + "', 'createFromDate':'"
				+ createFromDate + "', 'programFilterEnable':'" + programFilterEnable + "'}";
	}
	
	

}
