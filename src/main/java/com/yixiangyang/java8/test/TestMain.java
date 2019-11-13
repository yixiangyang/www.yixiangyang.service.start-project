package com.yixiangyang.java8.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestMain {

	public static void main(String[] args) {
		Formula formula = new Formula() {
			
			@Override
			public double calculate(int a) {
				return this.sqrt(a);
			}
		};
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(100));
		List<String> g = null;
		System.out.println(Optional.ofNullable(g));
	}

}
