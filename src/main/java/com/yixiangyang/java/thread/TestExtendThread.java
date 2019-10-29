package com.yixiangyang.java.thread;

public class TestExtendThread extends Thread{
	public void run(){
		System.out.println("ggg");
	}
	public static void main(String[] args) {
		TestExtendThread t = new TestExtendThread();
		t.start();
	}
}
