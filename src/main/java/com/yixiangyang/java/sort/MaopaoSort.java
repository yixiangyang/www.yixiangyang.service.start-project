package com.yixiangyang.java.sort;
/**
 * 冒泡排序
 * @author 15138
 *
 *1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *2、对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 *3、针对所有的元素重复以上的步骤，除了最后一个。
 *4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class MaopaoSort {

	public static void sort(int data[]) {
		for(int i = 0;i < data.length -1;i++) {
			System.out.println("i="+i);
			System.out.println("-------------华丽的分割线---------------");
			for(int j = 0;j<data.length - i -1;j++) {
				System.out.println("j="+j);
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int data[] = {4,8,12,3,50,1,7};
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
