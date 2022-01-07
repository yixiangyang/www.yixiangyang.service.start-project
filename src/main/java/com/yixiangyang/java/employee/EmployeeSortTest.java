package com.yixiangyang.java.employee;

import java.util.*;

/**
 * 2017-11-13
 * 给对象按照指定列进行排序
 * @author 伊向阳
 *
 */
public class EmployeeSortTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Employee1[] staff = new Employee1[3];
		staff[0] = new Employee1("yixiangyang", 80000);
		staff[1] = new Employee1("tom", 2000);
		staff[2] = new Employee1("jack", 500000);
		List<Employee1> list = new ArrayList<>();
		list = Arrays.asList(staff);
		Collections.sort(list,Collections.reverseOrder(new Comparator<Employee1>() {
			@Override
			public int compare(Employee1 o1, Employee1 o2) {
				int i = Double.valueOf(o1.getSalary()).compareTo(Double.valueOf(o2.getSalary()));
				return i;
			}
		}));
		//Collections.sort(list, c);
		//Arrays.sort(staff);
		for(Employee1 e:staff){
			System.out.println("name="+e.getName()+"   salary:"+e.getSalary());
		}
	}

}
class Employee1 implements Comparable<Employee1>{
	
	public Employee1(String n,double s){
		name = n;
		salary = s;
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}


	@Override
	public int compareTo(Employee1 o) {
		if(salary<o.salary){return -1;}
		if(salary>o.salary){return 1;}
		return 0;
	}
	private String name;
	private double salary;
}