package com.gwtjs.icustom.data.mongo.entity;

import com.gwtjs.icustom.data.mongo.StdProperties;

/**
 * 学员章节学习记录实体类
 * 
 * @author aGuang
 *
 */
public class StdItemPerformance extends StdProperties {

	/**
	 * 章节ID
	 */
	private String itemId;
	/**
	 * 学习状态
	 */
	protected String lessonStatus;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getLessonStatus() {
		return lessonStatus;
	}

	public void setLessonStatus(String lessonStatus) {
		this.lessonStatus = lessonStatus;
	}

}
