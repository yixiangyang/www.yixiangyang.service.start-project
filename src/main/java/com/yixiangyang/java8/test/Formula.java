package com.yixiangyang.java8.test;

/**
 * 测试Java8新特性，接口的默认方法
 * @author 15138
 *
 */
public interface Formula {
	double calculate(int a);
	
	/**
	 * 返回一个正的平方根
	 * @param a
	 * @return
	 */
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
