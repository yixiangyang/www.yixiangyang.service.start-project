package com.yixiangyang.java.hash;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 优先级队列
 * 优先级队列中的元素可以按照任意的顺序插入，但总是按照排序的顺序进行检索，在调用remove方法的时候总会获得当前优先级队列中最小的元素
 * @author 伊向阳
 *
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1915, Calendar.DECEMBER, 10));
		pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		System.out.println("华丽的分割线+++++++++++++++++++");
		for(GregorianCalendar date :pq){
			System.out.println(date.get(Calendar.YEAR));
		}
		if(!pq.isEmpty()){
			System.out.println("这个是:"+pq.remove().get(Calendar.YEAR));
		}
	}

}
