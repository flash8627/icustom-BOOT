package com.gwtjs.icustom.data.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.gwtjs.icustom.data.mongo.StdProperties;

/**
 * 学员单次学习记录实体类
 * 
 * @author aGuang
 *
 */
public class StdItemAttemp extends StdProperties {
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 *
	 */
	@Id
	private ObjectId id;
	/**
	 * 章节ID
	 */
	protected String itemId;
	/**
	 * 学习状态
	 */
	protected String lessonStatus;
	/**
	 * 播放设备源
	 */
	protected String driverType;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

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

	public String getDriverType() {
		return driverType;
	}

	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

}
