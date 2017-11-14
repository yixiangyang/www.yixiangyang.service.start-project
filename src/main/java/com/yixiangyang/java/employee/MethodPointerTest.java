package com.yixiangyang.java.employee;

import java.lang.reflect.Method;

/**
 * 2017-11-10
 * 方法指针测试
 * @author 伊向阳
 *
 */
public class MethodPointerTest {
	public static void main(String[] args) throws Exception {
		//平方
		Method square = MethodPointerTest.class.getMethod("square", double.class);
		//开方
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	}
	
	public static double square(double x){
		return x * x;
	}
	
	public static void printTable(double from,double to,int n,Method f){
		System.out.println(f);
		double dx = (to -from)/(n-1);
		for(double x= from;x<=to;x += dx){
			try {
				double y = (Double)f.invoke(null, x);
				System.out.printf("%10.4f | %10.5f%n",x,y);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
