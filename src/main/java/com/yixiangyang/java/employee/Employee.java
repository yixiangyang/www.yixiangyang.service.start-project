package com.yixiangyang.java.employee;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


public class Employee {
	/**名字*/
	private String name;
	/**薪水*/
	private double salary;
	/**聘请日期*/
	private Date hireDay;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
	
	public boolean equals(Object otherObject){
		if(this == otherObject) return true;
		
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()){return false;}
		Employee other = (Employee)otherObject;
		return Objects.equals(name, other.name) && salary == other.salary && 
				Objects.equals(hireDay, other.hireDay);
	}
	
	public int hashCode(){
		return Objects.hash(name,salary,hireDay);
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
	
	
}
