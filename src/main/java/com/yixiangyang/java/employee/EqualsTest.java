package com.yixiangyang.java.employee;

public class EqualsTest {

	public static void main(String[] args) {
		Employee alice1 = new Employee("员工1", 75000, 1999, 8, 15);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("员工1", 75000, 1999, 8, 15);
		Employee bob = new Employee("员工2", 75000, 1999, 8, 15);
		System.out.println("alice1 == alice2:"+(alice1 == alice2));
		System.out.println("alice2 == alice3:"+(alice2 == alice3));
		System.out.println("alice1 == alice3:"+(alice1 == alice3));
		System.out.println("alice1.equals(alice3):"+(alice1.equals(alice3)));
		System.out.println("alice2.equals(alice3):"+(alice2.equals(alice3)));
		System.out.println("bob.toString()"+bob);
		
		Manager carl = new Manager("伊向阳", 20000, 2018, 5, 3);
		Manager boss = new Manager("伊向阳", 20000, 2018, 5, 3);
		boss.setBonus(20000);
		System.out.println("boss.toString():"+boss);
		System.out.println("carl.equals(boss):"+carl.equals(boss));
		System.out.println("alice1.hashCode():"+alice1.hashCode());
		System.out.println("alice2.hashCode():"+alice2.hashCode());
		System.out.println("carl.hashCode():"+carl.hashCode());
		System.out.println("boss.hashCode():"+boss.hashCode());
	}

}
