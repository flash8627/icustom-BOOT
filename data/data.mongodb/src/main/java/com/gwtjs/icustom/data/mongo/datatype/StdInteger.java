package com.gwtjs.icustom.data.mongo.datatype;

/**
 * 整型数据类型
 * 
 * @author aGuang
 *
 */
public class StdInteger extends DataType {

	@Override
	public boolean isValid(String value) {
		boolean flag = false;
		try {
			int i = Integer.valueOf(value);
			if (i >= 0 && i <= 65536) {
				flag = true;
			}
		} catch (NumberFormatException nfe) {
			return flag;
		}
		return flag;
	}
}
