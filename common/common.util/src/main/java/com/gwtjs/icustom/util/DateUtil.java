package com.gwtjs.icustom.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;

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
	
}
