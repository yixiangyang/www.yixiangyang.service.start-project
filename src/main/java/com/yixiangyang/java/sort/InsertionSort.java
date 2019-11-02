package com.yixiangyang.java.sort;
/**
 * 插入排序
 * @author 15138
 *
 */
public class InsertionSort {

	public static void sort(int data[]) {
		for(int i=1;i<data.length ;i++) {
			for(int j = i;j>0;j--) {
				if(data[j]<data[j-1]) {
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int data[] = {4,8,12,3,1};
		for(int b:data) {
			System.out.println(b);
		}
		sort(data);
		System.out.println("-------------------------");
		for(int a:data) {
			System.out.println(a);
		}

	}

}
