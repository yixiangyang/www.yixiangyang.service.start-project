package com.yixiangyang.java.hash;

/*import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;*/

/**
 * 数组列表 set的测试
 * hashSet 是一个无序的集合 而TreeSet 是一个有序的集合 是按照排列好的顺序进行输出的 ，并且使用的结构是红黑树排序结构
 * @author 伊向阳
 *
 */
public class SetTest {

	public static void main(String[] args) {
		/*Set<String> words = new HashSet<String>();
		long totalTime = 0;
		Scanner in = new Scanner(System.in);
		int j= 1;
		while (j<5){
			String word = in.next();
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
			j++;
		}
		Iterator<String> iter = words.iterator();
		for(int i=1 ;i<=20;i++){
			System.out.println(iter.next());
		}
		System.out.println("...");
		System.out.println(words.size() + "distinct words."+totalTime + "millseconds");*/
		//Set<String> words = new HashSet<>();
		/*SortedSet<String> words = new TreeSet<>();
		words.add("aa");
		words.add("dd");
		words.add("gg");
		for(int i = 0;i<50;i++){
			words.add("ff"+i);
		}
		System.out.println(words);
		for(String w:words)
		System.out.println(w);*/
		Integer a = 10;
		Integer b = 9;
		String c ="a";
		String d = "b";
		String a1= "10";
		String b1 = "9";
		System.out.println(a1.compareTo(b1));
		System.out.println(a.compareTo(b));
		System.out.println(c.compareTo(d));
		
	}

}
