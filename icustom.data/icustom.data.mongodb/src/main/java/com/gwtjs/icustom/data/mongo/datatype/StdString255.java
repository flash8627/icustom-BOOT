package com.gwtjs.icustom.data.mongo.datatype;

/**
 * 字符串255长度数据类型
 * 
 * @author aGuang
 *
 */
public class StdString255 extends DataType {

	@Override
	public boolean isValid(String value) {
		boolean flag = false;

		if (null != value && value.length() < 255) {
			flag = true;
		}
		return flag;
	}

}
