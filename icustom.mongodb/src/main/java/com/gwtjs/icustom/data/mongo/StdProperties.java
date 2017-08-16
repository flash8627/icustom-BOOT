package com.gwtjs.icustom.data.mongo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 用户学习基础数据属性定义抽象类
 * 
 * @author aGuang
 *
 */

@JsonIgnoreProperties(value = { "createdBy", "creationDate", "lastUpdatedBy",
		"lastUpdateDate" })
public abstract class StdProperties {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 学习资源ID
	 */
	private String resId;
	/**
	 * 学习位置
	 */
	private String lessonLocation;
	/**
	 * 得分
	 */
	protected Float score;
	/**
	 * 学习时长
	 */
	private Long sessionTime;

	private Long createdBy;
	private Date creationDate;
	private Long lastUpdatedBy;
	private Date lastUpdateDate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getLessonLocation() {
		return lessonLocation;
	}

	public void setLessonLocation(String lessonLocation) {
		this.lessonLocation = lessonLocation;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Long getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Long sessionTime) {
		this.sessionTime = sessionTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
