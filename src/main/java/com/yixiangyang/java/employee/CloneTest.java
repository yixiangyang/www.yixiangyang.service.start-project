package com.yixiangyang.java.employee;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest {

	public static void main(String[] args){
		//
		//original.setHireDay(new Date(2017, 12, 11));
		try {
			Employee2 original = new CloneTest().new Employee2("aaaaa", 2222);
			original.setHireDay(2017, 11, 14);
			Employee2 copy = original.clone();
			System.out.println(copy.toString());
			copy.raiseSalary(100);
			copy.setHireDay(2012, 12, 12);
			System.out.println("original:"+original.toString());
			System.out.println("copy:"+copy.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	class Employee2 implements Cloneable{
		/**名字*/
		private String name;
		/**薪水*/
		private double salary;
		/**聘请日期*/
		private Date hireDay;
		public Employee2(String name, double salary) {
			super();
			this.name = name;
			this.salary = salary;
			this.hireDay = new Date();
		}
		public Employee2 clone() throws CloneNotSupportedException{
			Employee2 cloned = (Employee2)super.clone();
			cloned.hireDay =(Date) hireDay.clone();
			return cloned;
		}
		
		@Override
		public String toString() {
			return "Employee2 [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
		}
		public void setHireDay(int year,int month,int day){
			Date newHireDay = new GregorianCalendar(year, month-1, day).getTime();
			hireDay.setTime(newHireDay.getTime());
		}
		public void raiseSalary(double byPercent){
			double raise = salary * byPercent / 100;
			salary += raise;
		}
	}
}
