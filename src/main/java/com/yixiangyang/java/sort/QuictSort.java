package com.yixiangyang.java.sort;
/**
 * 快速排序
 * @author 15138
 *
 */
public class QuictSort {

	public static void sort(int data[],int start,int end) {
		if(end -start <=0 ) {
			return;
		}
		int last = start;
		for(int i = start +1;i<=end;i++) {
			if(data[i] <data[start]) {
				int temp = data[++last];
				data[last] = data[i];
				data[i]= temp;
			}
		}
		int temp = data[last];
		data[last] = data[start];
		data[start] = temp;
		sort(data, start, last-1);
		sort(data, last +1, end);
	}
	
	public static void main(String[] args) {
		int data[] = {4,8,12,3,1};
		for(int b:data) {
			System.out.println(b);
		}
		sort(data, 0, data.length-1);
		System.out.println("-------------------------");
		for(int a:data) {
			System.out.println(a);
		}

	}

}
