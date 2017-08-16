package com.gwtjs.icustom.data.mongo.entity;

import com.gwtjs.icustom.data.mongo.datatype.DataType;

/**
 * 布尔值数据类型
 * @author aGuang
 *
 */
public class StdBoolean extends DataType {

	@Override
	public boolean isValid(String value) {
		boolean flag = false;
		if ("true".equals(value) || "false".equals(value)) {
			flag = true;
		}
		return flag;
	}
}