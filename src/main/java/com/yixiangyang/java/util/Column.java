package com.yixiangyang.java.util;

public class Column {
	private String name;
	// 列值
	private Object value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Column() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Column(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}
	
}
