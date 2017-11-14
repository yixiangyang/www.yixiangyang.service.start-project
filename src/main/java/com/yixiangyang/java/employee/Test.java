package com.yixiangyang.java.employee;

public class Test {

	public static void main(String[] args) {
		Manager boss = new Manager("经理", 80000, 2001, 12, 15);
		boss.setBonus(5000);
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("员工1", 50000, 1999, 10, 1);
		staff[2] = new Employee("员工2", 40000,1998, 5, 5);
		for(Employee e:staff){
			System.out.println(e.getName() + " "+ e.getSalary());
		}
	}

}
