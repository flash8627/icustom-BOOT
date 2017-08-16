package com.gwtjs.icustom.data.mongo.service;

/**
 * 核心元素维护服务类
 * 
 * @author aGuang
 *
 */
public interface IStdCoreDataService {

	/**
	 *
	 * get:读取核心数据元素. <br/>
	 *
	 * @param resId
	 *            资源ID
	 * @param itemId
	 *            章节ID
	 * @param attempId
	 *            单次学习记录ID
	 * @param element
	 *            元素名
	 * @return 元素值
	 */
	public String get(String resId, String itemId, String attempId,
			String element);

	/**
	 *
	 * set:更新核心数据元素. <br/>
	 *
	 * @param resId
	 *            资源ID
	 * @param itemId
	 *            章节ID
	 * @param attempId
	 *            单次学习记录ID
	 * @param element
	 *            元素名
	 * @param value
	 *            元素值
	 * @return
	 */
	void set(String resId, String itemId, String attempId, String element,
			String value);

}
