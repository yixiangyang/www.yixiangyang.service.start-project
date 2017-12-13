package com.yixiangyang.java.thread;
/**
 * 银行 测试多线程
 * 2017-12-13
 * @author 伊向阳
 *
 */
public class Bank {
	private final double[] accounts;
	public Bank(int n,double initialBanlance){
		accounts = new double[n];
		for(int i = 0;i<accounts.length;i++){
			accounts[i] = initialBanlance;
		}
	}
	
	/**
	 * 转钱
	 */
	public synchronized void transfer(int from, int to,double amount){
		if(accounts[from] < amount){return;}
		System.out.println("当前线程:"+Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d",amount,from,to);
		accounts[to] += amount;
		System.out.printf("Total Balance:%10.2f%n",getTotalBalance());
	}
	
	public synchronized double getTotalBalance(){
		double sum = 0;
		for(double a : accounts){
			sum += a;
		}
		return sum;
	}
	
	public int size(){
		return accounts.length;
	}
}
