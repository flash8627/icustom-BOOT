package com.gwtjs.icustom.data.mongo.service;

import com.gwtjs.icustom.data.mongo.StdPerformance;
import com.gwtjs.icustom.data.mongo.entity.StdItemAttemp;
import com.gwtjs.icustom.data.mongo.entity.StdItemPerformance;

/**
 * 学习跟踪辅助服务类
 * 
 * @author aGuang
 *
 */
public interface ITrackingAssitService {
	/**
	 * 初始化单次学习记录
	 *
	 * @param resId
	 * @param itemId
	 * @param driverType
	 * @return
	 */
	public StdItemAttemp initilizeAttemp(String resId, String itemId,
			String driverType);

	/**
	 * 初始化章节学习记录
	 *
	 * @param stdPerformance
	 * @param resId
	 * @param itemId
	 * @return
	 */
	public StdItemPerformance initilizeItemPerformance(
			StdPerformance stdPerformance, String resId, String itemId);

	/**
	 * 初始化课程资源学习记录
	 *
	 * @param resId
	 * @param itemId
	 * @return
	 */
	public StdPerformance initilizePerformance(String resId, String itemId);

	/**
	 * 读取课程启动信息
	 *
	 * @param resId
	 * @return
	 */
	public StdPerformance launch(String resId);
}
