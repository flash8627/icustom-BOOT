package com.gwtjs.icustom.data.mongo.datatype;

/**
 * 学习跟踪系统，数据元素类型定义抽象类
 * @author aGuang
 *
 */
public abstract class DataType {
	
	public abstract boolean isValid(String value);
	
}
