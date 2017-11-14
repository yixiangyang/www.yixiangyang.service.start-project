package com.yixiangyang.testLotteryDrawing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 彩票抽奖测试
 * @author 伊向阳
 *
 */
public class LotteryDrawing {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("您需要多少个数字");
		int k = in.nextInt();
		System.out.println("输入你要的最大的数字");
		int n = in.nextInt();
		int[] numbers = new int[n];
		for(int i=0;i<numbers.length;i++)
			numbers[i] =i + 1;
		
		int[] result = new int[k];
		for(int i=0;i<result.length;i++){
			int r=(int)(Math.random() * n);
			result[i] = numbers[r];
			numbers[r] = numbers[n-1];
			n--;
		}
		Arrays.sort(result);
		System.out.println("++++++++++++");
		for(int r : result){
			System.out.println(r);
		}
		/*int[] result = new int[n];
		for(int i = 0;i < result.length;i++){
			int r = (int)(Math.random() * n);
			result[i] = numbers[r];
			
 		}*/
	}

}
