package com.yixiangyang.java8.localDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {
	public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter DTS = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static Date getCurrentDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}
	
	
	
	public static void main(String[] args) {
//		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(dft.format(getCurrentDate()));
//		System.out.println(getCurrentDate());
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.toLocalTime()); //获取时间(LocalTime)
        System.out.println(time.toLocalDate()); //获取日期(LocalDate)
        System.out.println(time.getDayOfMonth()); //获取当前时间月份的第几天
        System.out.println(time.getDayOfWeek());  //获取当前周的第几天
        System.out.println(time.getDayOfYear());  //获取当前时间在该年属于第几天
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getMonthValue());
        System.out.println(time.getMonth());
        //格式化输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(time.format(formatter));
        time =  time.plusYears(-1);//加一年
        time = time.minusYears(1);//减一年
//        System.out.println(time.plusYears(-1));
        //获取毫秒数(使用Instant)LocalDateTime
        System.out.println(time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        //获取秒数(使用Instant)
        System.out.println(time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        System.out.println(time.format(formatter));
        
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(2020, 1, 24, 0, 0, 0);
        System.out.println(Duration.between(currentTime, dateTime).toDays());//获取两个日期相减得到的天数
        
	}
}
