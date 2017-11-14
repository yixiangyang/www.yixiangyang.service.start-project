package com.yixiangyang.java.Array;

import java.util.Arrays;

/**
 *数组排序
 * @author 伊向阳
 *
 */
public class ArraySort {

	public static void main(String[] args) {
		
		int[] a = {5,3,6,8,7};
		
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		System.out.println(a);
	}

}
