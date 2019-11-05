package com.yixiangyang.java8.lambda;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Person {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmalAddress() {
		return emalAddress;
	}

	public void setEmalAddress(String emalAddress) {
		this.emalAddress = emalAddress;
	}

	public enum Sex{
		MALE, FEMALE
	}
	public String name;
	public Date birthday;
	public Sex gender;
	public String emalAddress;
	public int age;
	
	public int getAge(){
		return age;
		
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Date birthday, Sex gender, String emalAddress, int age) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emalAddress = emalAddress;
		this.age = age;
	}

	public void PrintPerson(){
		System.out.println("输出人");
	}
	
	public static void printPersonsOlderThan(List<Person> roster,int age){
		for(Person p: roster){
			if(p.getAge() >= age){
				p.PrintPerson();
			}
		}
	}
	
	public static void printPersonsWithinAgeRange(
		    List<Person> roster, int low, int high) {
		    for (Person p : roster) {
		        if (low <= p.getAge() && p.getAge() < high) {
		            p.PrintPerson();
		        }
		    }
		}
	
	public static void printPersons(
		    List<Person> roster, CheckPerson tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.PrintPerson();
		        }
		    }
		}

}
