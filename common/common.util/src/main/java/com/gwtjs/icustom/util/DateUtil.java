package com.gwtjs.icustom.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;

/**
 * <h2>字符型json数据转对象</h2>
 * @author aGuang
 *	<p>
 *	TODO 说明
 *</p>
 *<p>
 *	TODO 示例
 *</p>
 *<pre>
 *	示例代码:
 *</pre>
 */
public class DateUtil {
	
	/**
	 * "2017-05-25"
	 * @throws java.text.ParseException 
	 */
	static public Date stringToDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
	
	/**
	 * "2017-05-25"
	 * @throws java.text.ParseException 
	 */
	static public Date stringToEnDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
	
}
