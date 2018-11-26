package com.yixiangyang.application;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(8);
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					executors.execute(new Runnable() {
						
						@Override
						public void run() {
							for(int i=0;i<50;i++) {
								System.out.println("这个是a"+i);
							}
							
						}
					});
					executors.execute(new Runnable() {
						
						@Override
						public void run() {
							for(int i=0;i<50;i++) {
								System.out.println("这个是b"+i);
							}
							
						}
					});
				}
				
			},200, 1000);

	}

}
