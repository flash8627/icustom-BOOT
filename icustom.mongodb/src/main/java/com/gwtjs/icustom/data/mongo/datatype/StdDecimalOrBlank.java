package com.gwtjs.icustom.data.mongo.datatype;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 浮点值或者空值数据类型
 * 
 * @author aGuang 
 *
 */
public class StdDecimalOrBlank extends DataType {

	@Override
	public boolean isValid(String value) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		boolean flag = false;
		String patternStr = "^[-\\ ]?[.\\d] $";// 判断是否是浮点数
		boolean result = Pattern.matches(patternStr, value);
		if (result) {
			flag = true;
		}
		return flag;
	}
}
