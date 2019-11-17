package com.yixiangyang.application;

import java.util.ArrayList;

public class TestAB {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;
		System.out.println(a-b);
		if (a < b) {
		    System.out.println("a < b");
		}
		if (a - b < 0) {
		    System.out.println("a - b < 0");
		}
		new ArrayList<>();
	}
}
