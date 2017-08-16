package com.gwtjs.icustom.data.mongo.entity;

import com.gwtjs.icustom.data.mongo.datatype.DataType;

/**
 * 学习跟踪抽象模型封装
 * 
 * @author aGuang
 *
 */
public abstract class DataModel {
	/**
	 * 模型名：对应到数据元素名称; e.g. std.core._children
	 */
	protected String dataModelName;
	/**
	 * 是否可读
	 */
	protected boolean readable;
	/**
	 * 是否可写
	 */
	protected boolean writable;
	/**
	 * 数据类型
	 */
	protected DataType dataType;

	public DataModel(String dataModelName, boolean readable, boolean writable,
			DataType dataType) {
		this.dataModelName = dataModelName;
		this.readable = readable;
		this.writable = writable;
		this.dataType = dataType;
	}
}
