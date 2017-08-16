package com.gwtjs.icustom.data.mongo.constant;

public interface TrackConstant {
	/***************************** 学习跟踪字段初始值 *********************************/
	/**
	 * 初始学习时长
	 */
	Long DEFAULT_TIME = 0L;
	/***************************** 学习状态 *********************************/
	/**
	 * 完成
	 */
	String LEARN_STATUS_COMPLETED = "C";
	/**
	 * 未完成
	 */
	String LEARN_STATUS_INCOMPLETE = "I";
	/**
	 * 未进行
	 */
	String LEARN_STATUS_NOTSTART = "N";
	/***************************** 播放设备源 *********************************/
	/**
	 * pc
	 */
	String DRIVER_TYPE_PC = "P";
	/**
	 * mobile
	 */
	String DRIVER_TYPE_MOBILE = "M";
}
