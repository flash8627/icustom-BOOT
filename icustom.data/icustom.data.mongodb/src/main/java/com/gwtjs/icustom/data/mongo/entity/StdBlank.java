package com.gwtjs.icustom.data.mongo.entity;

import org.apache.commons.lang3.StringUtils;

import com.gwtjs.icustom.data.mongo.datatype.DataType;

/**
 * 空值数据类型
 * @author aGuang
 *
 */
public class StdBlank extends DataType {

	@Override
	public boolean isValid(String value) {
		boolean isBlank = false;
		if (StringUtils.isBlank(value)) {
			isBlank = true;
		}
		return isBlank;
	}
}
