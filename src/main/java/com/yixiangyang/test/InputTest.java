package com.yixiangyang.test;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("你叫 什么名字");
		String a = in.nextLine();
		System.out.println("我的名字是"+a);
		System.out.println("你几岁了");
		int age = in.nextInt();
		System.out.println(a+"今年"+age+"岁");
	}

}
