package com.yixiangyang.java8.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("第一个人", new Date(), Person.Sex.MALE, "地址", 21));
		Person person = new Person();
		person.printPersonsOlderThan(persons, 20);
		
		person.printPersons(persons, new CheckPersonEligibleForSelectiveService());
		
		person.printPersons(persons, (Person p)->p.getGender() == Person.Sex.MALE 
				&& p.getAge() >=18 && p.getAge()<= 25);
	}

}
