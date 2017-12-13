package com.yixiangyang.java.set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		System.out.println(a);
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		while(bIter.hasNext()){
			if(aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println(a);
		System.out.println(b);
		bIter = b.iterator();
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println("这是移除后的b:"+b);
		a.removeAll(b);
		System.out.println(a);
	}

}
