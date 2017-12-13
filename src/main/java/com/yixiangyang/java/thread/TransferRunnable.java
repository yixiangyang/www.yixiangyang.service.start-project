package com.yixiangyang.java.thread;

public class TransferRunnable implements Runnable {

	private Bank bank;
	private double maxAmount;
	private int fromAccount;
	private int DELAY = 10;
	
	public TransferRunnable(Bank b,int from, double max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				int toAccount = (int)(bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		} catch (Exception e) {
		}
	}

}
