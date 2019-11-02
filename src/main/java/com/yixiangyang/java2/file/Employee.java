package com.yixiangyang.java2.file;

import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee {
	/**名字*/
	private String name;
	/**薪水*/
	private double salary;
	/**聘请日期*/
	private Date hireDay;
	
	private static final int NAME_SIZE = 40;
	
	@SuppressWarnings("unused")
	private static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String n,double s,int year,int month,int day){
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	
	/**
	 * 提高工资
	 * @param byPercent
	 */
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public static final double formatTwo(double data){
		DecimalFormat df = new DecimalFormat("#");
		return Double.valueOf(df.format(data));
	}
	public static String doubleTrans1(double num){
	    if(num % 1.0 == 0){
		        return String.valueOf((long)num);
	    }
	    return String.valueOf(num);
}
	/**
	 * 写入数据
	 * @param out
	 */
	public void writeData(PrintWriter out){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR) + "|" 
				+(calendar.get(Calendar.MONTH)+1)  + "|" + calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 二进制形式写出数据
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public void dataOutputWritData(DataOutput out) throws IOException{
		DataIO.writeFixedString(name, NAME_SIZE, out);
		out.writeDouble(salary);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.writeInt(calendar.YEAR);
		out.writeInt((calendar.MONTH)+1);
		
	}
	/**
	 * 读取数据
	 */
	public void readData(Scanner in){
		String line = in.nextLine();
		String[] tokens  =line.split("\\|");
		name = tokens[0];
		salary = Double.parseDouble(tokens[1]);
		int y = Integer.parseInt(tokens[2]);
		int m = Integer.parseInt(tokens[3]);
		int d = Integer.parseInt(tokens[4]);
		Calendar calendar = new GregorianCalendar(y , m -1, d);
		hireDay = calendar.getTime();
	}
	
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return getClass().getName() + "[name=" + name + ", salary=" + salary + ", hireDay=" + sdf.format(hireDay) + "]";
	}
}
