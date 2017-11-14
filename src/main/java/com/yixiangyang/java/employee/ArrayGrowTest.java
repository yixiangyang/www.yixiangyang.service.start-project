package com.yixiangyang.java.employee;

import java.lang.reflect.Array;

/**
 * 数组增长测试 让数组增长多少个单位
 * @author 伊向阳
 *
 */
public class ArrayGrowTest {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		a = (int[])goodArrayGrow(a);
		arrayPrint(a);
		String[] b = {"Tom","yixiangyang","Jack"};
		b = (String[])goodArrayGrow(b);
		arrayPrint(b);
		//下面的调用会产生 一个异常
		b=(String[])badArrayGrow(b);
	}
	static Object[] badArrayGrow(Object[] a){
		int length = Array.getLength(a);
		int newLength = a.length * 11/10 +10;
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
	}
	@SuppressWarnings("rawtypes")
	static Object goodArrayGrow(Object a){
		Class cl = a.getClass();
		if(!cl.isArray()){
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		int newLength = length * 11/10 +10;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
	}
	@SuppressWarnings("rawtypes")
	static void arrayPrint(Object a){
		Class cl = a.getClass();
		if(!cl.isArray()){return;}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		System.out.print(componentType.getName()+"["+length+"] = {");
		for(int i=0;i<Array.getLength(a);i++){
			System.out.print(Array.get(a, i)+" ");
		}
		System.out.println("}");
	}
}
