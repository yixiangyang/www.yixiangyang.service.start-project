package com.yixiangyang.java.employee;

import java.math.BigDecimal;

public class t {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(365);
		BigDecimal b = new BigDecimal(12);
		double c = a.divide(b, 12, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(c);
	}

}
