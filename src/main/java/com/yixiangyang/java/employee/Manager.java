package com.yixiangyang.java.employee;

public class Manager extends Employee{
	
	private double bonus;

	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		// TODO Auto-generated constructor stub
	}
	
	public double getSalary(){
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject)){return false;}
		Manager other = (Manager)otherObject;
		return bonus == other.bonus;
	}
	
	public int hashCode(){
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}
	
	public String toString(){
		return super.toString() + "[bonus=" + bonus +"]";
	}
}
