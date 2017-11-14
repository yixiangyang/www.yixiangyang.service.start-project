package com.yixiangyang.java.employee;

import java.util.*;

/**
 * 2017-11-08
 * 测试枚举的使用
 * @author 伊向阳
 *
 */
public class EnumTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size :(SMALL,MEDIUM,LARGE,EXTRA_LARCE)");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size == Size.EXTRA_LARGE){
			//干的好,你要注意了
			System.out.println("Good job --you paid attention to the");
		}
	}
	
	enum Size{
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
		private Size(String abbreviation){ this.abbreviation = abbreviation;}
		private String getAbbreviation(){return abbreviation;}
		/**缩写*/
		private String abbreviation;
	}
}
