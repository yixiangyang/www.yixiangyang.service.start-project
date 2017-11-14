package com.yixiangyang.java.employee;
/**
 * 2017-11-09
 * 在运行时使用反射分析对象
 * @author 伊向阳
 *
 */

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzerTest {

	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<Integer>();
		for(int i=1;i<=5;i++){
			squares.add(i *i);
		}
		
		System.out.println(new ObjectAnalyzer().toString(squares));
	}
}
//void setAccessible(boolean flag) 
//反射对象设置可访问标志。flag为true表明屏蔽java语言的访问机制,使得对象的私有属性也可以被查询和设置

class ObjectAnalyzer{
	/**
	 * 将对象转换为列出所有字段的字符串表示形式
	 * @param obj
	 * @return 包含对象类名和所有字段名称和值的字符串
	 */
	@SuppressWarnings("rawtypes")
	public String toString(Object obj){
		if(obj == null){
			return "null";
		}
		if(visited.contains(obj)){
			return "...";
		}
		visited.add(obj);
		Class cl = obj.getClass();
		if(cl == String.class){
			return (String)obj;
		}
		if(cl.isArray()){
			String r = cl.getComponentType()+"[]{";
			for(int i=0;i<Array.getLength(obj);i++){
				if(i>0){
					r +=",";
				}
				Object val = Array.get(obj, i);
				if(cl.getComponentType().isPrimitive()){ r+= val;}
				else{r+= toString(val);}
			}
			return r +"}";
		}
		String r = cl.getName();
		do{
			r +="{";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			for(Field f:fields){
				if(!Modifier.isStatic(f.getModifiers())){
					if(!r.endsWith("[")){
						r += ",";
					}
					r += f.getName()+"=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if(t.isPrimitive()){
							r += val;
						}else{
							r += toString(val);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r +="]";
			cl =cl.getSuperclass();
		}
		while(cl !=null);
		return r;
	}
	private ArrayList<Object> visited = new ArrayList<Object>();
}
