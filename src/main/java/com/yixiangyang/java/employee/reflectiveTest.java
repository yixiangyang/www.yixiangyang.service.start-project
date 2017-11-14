package com.yixiangyang.java.employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Scanner;


/**
 * Java的反射测试
 * @author 伊向阳
 *
 */
public class reflectiveTest {

	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) throws ClassNotFoundException {
		//Class
		Date date = new Date();
		Class cl = date.getClass();
		System.out.println(cl.getName());
		String className = "java.util.Date";
		Class cll = Class.forName(className);
		System.out.println(cll);
		//下面做的是反射测试
		String name;
		if(args.length > 0){
			name = args[0];
		}else{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (java.util.Date):");
			name = in.next();
		}
		try {
			Class cl1 = Class.forName(name);
			Class supercl = cl.getSuperclass();
			//modifiers 是修饰符的意思
			String modifiers = Modifier.toString(cl1.getModifiers());
			if(modifiers.length()>0){
				System.out.println(modifiers + "   " );
			}
			System.out.println("class :"+ name);
			if (supercl != null && supercl != Object.class){
				System.out.print("extends :"+supercl.getName());
			}
			System.out.println("{\n");
			prinitConstructors(cl1);
			System.out.println("++++++++++++++");
			printMethods(cl1);
			System.out.println("  -------华丽的分割符------");
			printFileds(cl1);
			System.out.println("\n}");
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	@SuppressWarnings("rawtypes")
	public static void prinitConstructors(Class cl){
		//constructors 是构造函数的意思
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c : constructors){
			String name = c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0){
				System.out.print(modifiers +"  " +name +"(");
			}
			Class[] paramTypes = c.getParameterTypes();
			for(int i=0;i<paramTypes.length;i++){
				if(i>0){
					System.out.print(", ");
				}
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	
	//获得方法
	@SuppressWarnings("rawtypes")
	public static void printMethods(Class cl){
		//获取包含从超类中继承过来的方法 返回一个包含method方法的数组
		Method[] methods = cl.getMethods();
		for(Method m : methods){
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print(" ");
			//输出修饰符，返回的类型 方法和名字
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length()>0){
				System.out.print(modifiers+" ");
			}
			System.out.print(retType.getName() +" "+name +"(");
			Class[] paramTypes = m.getParameterTypes();
			for(int i=0;i<paramTypes.length;i++){
				if(i>0){System.out.print(",");}
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void printFileds(Class cl){
		Field[] fields = cl.getDeclaredFields();
		for(Field f: fields){
			Class type = f.getType();
			String name = f.getName();
			System.out.println("  ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0){
				System.out.print( modifiers +" ");
			}
			System.out.println(type.getName()+" "+name+";");
		}
	}
}
