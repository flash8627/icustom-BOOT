package com.gwtjs.icustom.htmlarea.vo;

import java.util.Date;

import com.gwtjs.icustom.entity.BaseResource;

/**
 * 公共功能-富文本-VO
 * 
 * @author aGuang
 *
 */
public class HtmlAreaVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6970590248287107679L;

	public HtmlAreaVO() {
	}

	private int htmlAreaId;
	/** 标题 **/
	private String title;
	/** 名称 **/
	private String name;
	/** 映射URL **/
	private String mappingUrl;
	/** 内容 **/
	private String content;
	/** 描述 **/
	private String description;
	/** 富文本类型 **/
	private String category;

	/** 一级类型 **/
	private String secondLevelType;
	/** 二级类型 **/
	private String thirdLevelType;
	/** 日期-结束日期 */
	private Date validToDate;
	/** 日期-开始时间 */
	private Date validFromDate;
	/**
	 * 是否启用了富文本的program过滤
	 * 
	 * @since 2017-10-07
	 */
	private boolean programFilterEnable;

	public int getHtmlAreaId() {
		return htmlAreaId;
	}

	public void setHtmlAreaId(int htmlAreaId) {
		this.htmlAreaId = htmlAreaId;
	}

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

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	@Override
	public String toString() {
		return "{'category':'" + category + "', 'name':'" + name + "', 'description':'" + description + "', 'content':'"
				+ content + "', 'title':'" + title + "', 'mappingUrl':'" + mappingUrl + "', 'secondLevelType':'"
				+ secondLevelType + "', 'thirdLevelType':'" + thirdLevelType + "', 'validToDate':'" + validToDate
				+ "', 'validFromDate':'" + validFromDate + "', 'programFilterEnable':'" + programFilterEnable + "'}";
	}

}
