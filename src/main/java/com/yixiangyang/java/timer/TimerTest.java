package com.yixiangyang.java.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	public static void main(String[] args) {
		ActionListener listener =  new TimerTest().new TimerPrinter();
		Timer t = new Timer(1000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		t.stop();
		//System.exit(0);
		for(int i=0;i<10;i++){
			System.out.println("这是:"+i);
		}
	}
	class TimerPrinter implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("时间是:"+sdf.format(now));
			Toolkit.getDefaultToolkit().beep();
		}
	}
}
