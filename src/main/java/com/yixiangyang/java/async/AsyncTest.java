package com.yixiangyang.java.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 使用原生的CompletableFuture实现异步操作，
 * 
 * @author 15138
 *
 */
public class AsyncTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main函数开始执行");
		ExecutorService executor = Executors.newFixedThreadPool(2);
//		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
//			@Override
//			public Integer get() {
//				System.out.println("===task start===");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("===task finish===");
//				return 3;
//			}
//		}, executor);
//		future.thenAccept(e -> System.out.println(e));
		String a = "aaa";
		CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(new Supplier<List<String>>() {

			@Override
			public List<String> get() {
				// TODO Auto-generated method stub
				List<String> list = new ArrayList<String>();
				try {
					Thread.sleep(50000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(a);
				return list;
			}
			
		},executor);
//		System.out.println(future1.get().get(0));
		future1.thenAccept(list -> list.stream().forEach(System.out::println ));
		System.out.println("main函数执行结束");
//		executor.shutdown();
	}

}
