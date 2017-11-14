package com.yixiangyang.java.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		//Locale.setDefault(Locale.ITALIAN);
		GregorianCalendar now = new GregorianCalendar();
		System.out.println(now.get(Calendar.YEAR));
		
		System.out.println(now.getTime());
		System.out.println(now.get(Calendar.MONTH));
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.MONDAY));
		

	}

}
