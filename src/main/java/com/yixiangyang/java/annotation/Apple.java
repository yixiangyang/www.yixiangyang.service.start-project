package com.yixiangyang.java.annotation;


import com.yixiangyang.java.annotation.FruitColor.Color;
public class Apple {
	@FruitName(value="平果")
	private String appleName;
	@FruitColor(fruitColor = Color.RED)
	private String appleColor;
	@FruitProvider(id = 5,name = "伊向阳")
	private String appleProvider;

	public String getAppleName() {
		System.out.println("bbbb");
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}


}
