package com.yixiangyang.java.set;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> staff = new LinkedList<>();
		staff.add("tom");
		staff.add("joe");
		staff.add("jack");
		System.out.println(staff);
		/*Iterator<String> itor = staff.iterator();
		String first = itor.next();
		String second = itor.next();
		itor.remove();
		System.out.println(staff);*/
		ListIterator<String> listItor = staff.listIterator();
		
		listItor.next();
		listItor.add("me");
		System.out.println(staff);
	}

}
