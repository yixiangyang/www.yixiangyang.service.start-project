package com.yixiangyang.java.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class LocalDateUtil {
	/**
	 * 获取当前时间的毫秒
	 * @return
	 */
	public static Long getCurrentMillisecond() {
		return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}
	/**
	 * 获取当前时间的秒
	 * @return
	 */
	public static Long getCurrentSecond() {
		return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
	}
	
	//将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
    public static LocalDateTime dateConvertToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }
 
   
    //将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }
	
    /**
	 * 解析时间字符串成YYYYMMDDHHMMSS
	 * @param dateText
	 * @return
	 */
	public static final Date parseYYYYMMDDHHMMSS(String dateText) {
		if(dateText == null) {return null;}
		try {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(dateText, df);
			return localDateTimeConvertToDate(dateTime);
		} catch (Exception e) {
			
			return null;
		}
	}
	
	public static final String formatYYYY_MM_DDHHMMSS(long time) {
		DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String longToDateTime = df.format(LocalDateTime.ofInstant(
		   Instant.ofEpochMilli(time),ZoneId.of("Asia/Shanghai")));
		return longToDateTime;
	}
	
	/**
	 * 解析时间字符串成YYYYMMDDHHMMSS
	 * @param dateText
	 * @return
	 */
//	public static final Timestamp parseYYYYMMDD(String dateText) {
//		if(dateText == null) {return null;}
//		try {
//			Date date = YYYYMMDDFORMATER.parse(dateText);
//			return new Timestamp(date.getTime());
//		} catch (ParseException e) {
//			LOGGER.error(DateUtil.class+"-parseYYYYMMDD -"+e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 解析时间字符串成YYYYMM
//	 * @param dateText
//	 * @return
//	 */
//	public static final Timestamp parseYYYYMM(String dateText) {
//		if(dateText == null) {return null;}
//		try {
//			Date date = YYYYMMFORMATER.parse(dateText);
//			return new Timestamp(date.getTime());
//		} catch (ParseException e) {
//			LOGGER.error(DateUtil.class+"-parseYYYYMM -"+e);
//			return null;
//		}
//	}
//	
//	/**
//	 * 比较是否同一天
//	 * @param date1
//	 * @param date2
//	 * @return
//	 */
//	public static boolean isSameDay(Date date1, Date date2) {
//		String day1 = YYYYMMDDFORMATER.format(date1);
//		String day2 = YYYYMMDDFORMATER.format(date2);
//		return day1.equals(day2);
//	}
	
	
    
	public static void main(String[] args) {
		System.out.println(getCurrentMillisecond());
		System.out.println("秒:"+getCurrentSecond());
		System.out.println(parseYYYYMMDDHHMMSS("2019-12-12 10:47:47"));
		System.out.println(formatYYYY_MM_DDHHMMSS(parseYYYYMMDDHHMMSS("2019-12-12 10:47:47").getTime()));
		System.out.println(DateFormat.getInstance());
	}
}
