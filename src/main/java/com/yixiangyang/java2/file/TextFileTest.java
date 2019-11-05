package com.yixiangyang.java2.file;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("JACK", 75000, 1987, 12, 16);
		staff[1] = new Employee("TOM", 50000, 1989, 12, 1);
		staff[2] = new Employee("ROM",40000, 1990, 3, 15);
		try {
			PrintWriter out = new PrintWriter("employee.txt");
			writeData(staff, out);
			out.close();
			
			Scanner in = new Scanner(new FileReader("employee.txt"));
			Employee[] newStaff = readData(in);
			in.close();
			for(Employee e:newStaff){
				System.out.println(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 写入
	 * @param employees
	 * @param out
	 */
	private static void writeData(Employee[] employees,PrintWriter out){
		out.println(employees.length);
		for(Employee e : employees){
			e.writeData(out);
		}
	}
	
	private static Employee[] readData(Scanner in){
		int n =in.nextInt();
		in.nextLine();
		Employee[] employees = new Employee[n];
		for(int i = 0;i < n; i++ ){
			employees[i] = new Employee();
			employees[i].readData(in);
		}
		return employees;
	}

}
