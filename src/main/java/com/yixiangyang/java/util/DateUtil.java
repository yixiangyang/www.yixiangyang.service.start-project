package com.yixiangyang.java.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	public static Map<String, Long> difference(Date startDate, Date endDate) {
		HashMap<String, Long> m = new HashMap<String, Long>();
		long different = endDate.getTime() - startDate.getTime();
		long secondsInMilli = 1000L;
		long minutesInMilli = secondsInMilli * 60L;
		long hoursInMilli = minutesInMilli * 60L;
		long daysInMilli = hoursInMilli * 24L;
		long elapsedDays = different / daysInMilli;
		different %= daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different %= hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different %= minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		m.put("DAYS", Long.valueOf(elapsedDays));
		m.put("HOURS", Long.valueOf(elapsedHours));
		m.put("MINUTES", Long.valueOf(elapsedMinutes));
		m.put("SECONDS", Long.valueOf(elapsedSeconds));
		return m;
	}
}
