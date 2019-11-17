package com.yixiangyang.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		stringList.add("ddd2");
		stringList.add("aaa2");
		stringList.add("bbb1");
		stringList.add("aaa1");
		stringList.add("bbb3");
		stringList.add("ccc");
		stringList.add("bbb2");
		stringList.add("ddd1");
		
		stringList.stream().filter(a -> a.startsWith("b")).forEach(System.out::println);
		System.out.println(stringList.stream().filter(a -> a.startsWith("b")).collect(Collectors.toList()).size());
		System.out.println(stringList.stream().filter(a -> a.startsWith("b")).count());
		List< String> list = stringList.stream().filter(a -> a.startsWith("a")).collect(Collectors.toList());
		System.out.println(stringList.stream().reduce("",String::concat));
	}

}
