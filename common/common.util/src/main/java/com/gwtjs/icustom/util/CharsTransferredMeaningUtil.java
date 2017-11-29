package com.gwtjs.icustom.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符转义
 * @author aGuang
 * 
 */
public class CharsTransferredMeaningUtil {
	
	/*** 转义字符* @param value* @return */
	static public String filter(String value) {
		if (value == null) {
			return null;
		}
		StringBuffer result = new StringBuffer(value.length());
		for (int i = 0; i < value.length(); ++i) {
			switch (value.charAt(i)) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#39;");
				break;
			case '%':
				result.append("&#37;");
				break;
			case ';':
				result.append("&#59;");
				break;
			case '(':
				result.append("&#40;");
				break;
			case ')':
				result.append("&#41;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '+':
				result.append("&#43;");
				break;
			default:
				result.append(value.charAt(i));
				break;
			}
		}
		return result.toString();
	}

	/**
	 * 过滤掉用户输入中的危险字符
	 * 
	 * @param value
	 * @return
	 */
	static public String filterDangerString(String value) {
		if (null == value)
			return null;
		value = value.replaceAll("script", "ipscrt");
		value = value.replaceAll("applet", "letapp");
		value = value.replaceAll("embed", "bedem");

		return value;
	}

	/**
	 * 将 inStr 转为 UTF - 8 的编码形式
	 * 
	 * @param inStr
	 *            输入字符串
	 * @return UTF - 8 的编码形式的字符串
	 * @throws UnsupportedEncodingException
	 */
	static public String toUTF(String inStr)
			throws UnsupportedEncodingException {
		String outStr = "";
		if (inStr != null) {
			// outStr=java.net.URLDecoder.decode(inStr);// 不用 decode 了 ,
			// 到这的时候就已经自动 decode 过了
			// 将字符串转为 UTF-8 编码形式
			outStr = new String(inStr.getBytes("iso-8859-1"), "UTF-8");
		}
		return outStr;
	}
	
}
