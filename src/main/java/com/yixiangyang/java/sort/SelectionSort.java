package com.yixiangyang.java.sort;
/**
 * 选择排序
 * @author 15138
 *选择排序法的第一层循环从起始元素开始选到倒数第二个元素，主要是在每次进入的第二层循环之前，将外层循环的下标赋值给临时变量，接下来的第二层循环中，
 *如果发现有比这个最小位置处的元素更小的元素，则将那个更小的元素的下标赋给临时变量，最后，在二层循环退出后，
 *如果临时变量改变，则说明，有比当前外层循环位置更小的元素，需要将这两个元素交换.
 */
public class SelectionSort {

	public static void sort(int data[]) {
		int minVal;
		int minIndex;
		for(int i = 0;i<data.length-1;i++) {
			System.out.println("----------------------");
			minVal = data[i];
			minIndex = i;
			for(int j = i+1;j<data.length;j++) {
				if(data[j]<minVal) {
					minVal = data[j];
					minIndex = j;
				}
			}
			if(minVal !=data[i] && minIndex !=i) {
				data[minIndex] = data[i];
				data[i] = minVal;
			}
			for(int a:data) {
				System.out.println("这是"+a);
			}
		}
	}
	
	public static void main(String[] args) {
		int data[] = {4,8,12,3,1,50};
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
