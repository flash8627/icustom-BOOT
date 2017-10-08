package com.gwtjs.icustom.data.mongo.entity;

import java.util.HashMap;
import java.util.Map;

import com.gwtjs.icustom.data.mongo.constant.TrackConstant;
import com.gwtjs.icustom.data.mongo.datatype.DataType;
import com.gwtjs.icustom.data.mongo.datatype.StdDecimalOrBlank;
import com.gwtjs.icustom.data.mongo.datatype.StdInteger;
import com.gwtjs.icustom.data.mongo.datatype.StdString255;
import com.gwtjs.icustom.data.mongo.datatype.StdVocabulary;

/**
 * 学习跟踪系统，针对标准课件的核心数据模型定义类
 * 
 * @author aGuang
 *
 */
public class StdCoreData extends DataModel {
	/**
	 * 学员ID
	 */
	public static final String STUDENT_ID = "std.core.student_id";
	/**
	 * 学员姓名
	 */
	public static final String STUDENT_NAME = "std.core.student_name";
	/**
	 * 学习定位
	 */
	public static final String LESSON_LOCATION = "std.core.lesson_location";
	/**
	 * 章节学习状态
	 */
	public static final String LESSON_STATUS = "std.core.lesson_status";
	/**
	 * 得分
	 */
	public static final String SCORE_RAW = "std.core.score";
	/**
	 * 学习总时间
	 */
	public static final String TOTAL_TIME = "std.core.total_time";
	/**
	 * 单次学习时长
	 */
	public static final String SESSION_TIME = "std.core.session_time";

	public static final Map<String, DataModel> CORE_DATA_MAP = new HashMap<String, DataModel>();

	static {
		CORE_DATA_MAP.put(STUDENT_ID, new StdCoreData(STUDENT_ID, true, false,
				new StdInteger()));
		CORE_DATA_MAP.put(STUDENT_NAME, new StdCoreData(STUDENT_NAME, true,
				false, new StdString255()));
		CORE_DATA_MAP.put(LESSON_LOCATION, new StdCoreData(LESSON_LOCATION,
				true, true, new StdString255()));
		CORE_DATA_MAP.put(LESSON_STATUS, new StdCoreData(LESSON_STATUS, true,
				true, new StdVocabulary(new String[] {
						TrackConstant.LEARN_STATUS_COMPLETED,
						TrackConstant.LEARN_STATUS_INCOMPLETE })));
		CORE_DATA_MAP.put(SCORE_RAW, new StdCoreData(SCORE_RAW, true, true,
				new StdDecimalOrBlank()));
		CORE_DATA_MAP.put(TOTAL_TIME, new StdCoreData(TOTAL_TIME, true, false,
				new StdInteger()));
		CORE_DATA_MAP.put(SESSION_TIME, new StdCoreData(SESSION_TIME, false,
				true, new StdInteger()));
	}

	private StdCoreData(String dataModelName, boolean readEnable,
			boolean writeEnable, DataType dataType) {
		super(dataModelName, readEnable, writeEnable, dataType);
	}

	public static boolean contains(String element) {
		return CORE_DATA_MAP.containsKey(element);
	}

	public static DataModel get(String element) {
		return CORE_DATA_MAP.get(element);
	}
}