package com.yixiangyang.java.async;

public class UseThreadTest {
	public static void main(String[] args) {
		System.out.println("这个是开始");
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Thread.sleep(6000);
//					System.out.println("线程结束");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		thread.start();
//		System.out.println("这个是结束");
		
		for(int i=0 ;i<5;i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(6000);
						System.out.println("线程结束");
						System.out.println(Thread.currentThread().getName() +"   ");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			
		}
		System.out.println("这个是结束");
	}
}
