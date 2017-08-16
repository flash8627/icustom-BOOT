package com.gwtjs.icustom.data.mongo.datatype;

/**
 * 字符串取值列表类型
 * 
 * @author aGuang
 *
 */
public class StdVocabulary extends DataType {

	private String[] vocabularies;

	public StdVocabulary(String[] vocabularies) {
		this.vocabularies = vocabularies;
	}

	@Override
	public boolean isValid(String value) {

		if (null != value) {
			for (int j = 0; j < vocabularies.length; j++) {
				if (value.equals(vocabularies[j]))
					return true;
			}
		}
		return false;
	}
}
