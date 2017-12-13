package com.yixiangyang.java.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 49 ; i ++){
			numbers.add(i);
		}
		System.out.println(numbers);
		//随机的打乱 列表中的元素。
		Collections.shuffle(numbers);
		System.out.println(numbers);
		List<Integer> winningCombination = numbers.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
	}

}
