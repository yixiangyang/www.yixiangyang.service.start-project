package com.yixiangyang.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadExecutor {
	static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

	public static void main(String[] args) {
		testSingleExecutor();
	}

	// 测试单线程的线程池
	private static void testSingleExecutor() {
		for (int i = 0; i < 6; i++) {
			final int index = i;
			singleExecutor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(3000);
						System.out.println("睡眠三秒"+ index);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " index:" + index);
				}
			});
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4秒后...");
		singleExecutor.shutdown();
	}
}
