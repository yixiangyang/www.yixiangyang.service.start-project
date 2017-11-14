package com.yixiangyang.test;

import java.math.BigDecimal;

public class javaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aa");
		System.out.println(new BigDecimal(1555555555.66699999999));
		int n=7;
		int m=7;
		int a = 2 + ++n;
		int b = 2 + m++;
		System.out.println(a +"  "+b);
		
		int fourthBitFromRight = (n & ( 1<<3)) >>3;
		System.out.println(fourthBitFromRight);
		System.out.println(Math.sqrt(4));//计算平方根
	}

}
