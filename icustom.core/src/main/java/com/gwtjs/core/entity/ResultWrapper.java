package com.gwtjs.core.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一的返回类型
 * 
 * @author aGuang
 *
 */
public class ResultWrapper {

	/**
	 * 请求成功
	 */
	public static short STATUS_SUCCESS = 1;
	/**
	 * 请求失败
	 */
	public static short STATUS_ERROR = 0;
	/**
	 * 狀態值
	 */
	private short status;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 數據對象【普通對象，列表，分頁對象】
	 */
	private Object data;
	/**
	 * 錯誤碼【請求失敗時賦值】
	 */
	private String errorCode;

	private ResultWrapper(short status, String msg, Object data,
			String errorCode) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.errorCode = errorCode;
	};
	


	public static ResultWrapper successResult(Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, "", data, null);
	}

	public static ResultWrapper constructSuccessResult(Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, "", data, null);
	}

	public static ResultWrapper constructSuccessResult(String msg, Object data) {
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, msg, data, null);
	}

	public static ResultWrapper constructErrorResult(String msg,
			String errorCode) {
		return new ResultWrapper(ResultWrapper.STATUS_ERROR, msg, null,
				errorCode);
	}

	public static ResultWrapper constructSingleSuccessResult(String msg,
			String key, String data) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put(key, data);
		return new ResultWrapper(ResultWrapper.STATUS_SUCCESS, msg, resultMap,
				null);
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

}
