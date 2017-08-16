package com.gwtjs.icustom.data.mongo.entity;

import java.util.regex.Pattern;

import com.gwtjs.icustom.data.mongo.datatype.DataType;

/**
 * 浮点值数据类型
 * @author aGuang
 *
 */
public class StdDecimal extends DataType {

	@Override
	public boolean isValid(String value) {
		boolean flag = false;
		String patternStr = "^[-\\ ]?[.\\d] $";// 判断是否是浮点数
		boolean result = Pattern.matches(patternStr, value);
		if (result) {
			flag = true;
		}
		return flag;
	}

}
