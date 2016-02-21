package com.go2plus.core.common.utils;

import org.joda.time.DateTime;

/**
 * <p>User: mtwu
 * <p>Date: @2014-8-18
 * <p>Version: 1.0
 */
public class DateUtils {
	
	private static final String format_date ="yyyyMMdd";
	private static final String format_time ="HHmmss";
	private static final String format_date_time ="yyyyMMddHHmmss";
	
	public static String getCurDate(){
		return DateTime.now().toString(format_date);
	}
	public static String getCurTime(){
		return DateTime.now().toString(format_time);
	}
	public static String getCurDateTime(){
		return DateTime.now().toString(format_date_time);
	}
}
