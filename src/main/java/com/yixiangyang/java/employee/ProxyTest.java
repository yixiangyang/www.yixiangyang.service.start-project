package com.yixiangyang.java.employee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 代理测试
 * 2017-11-15
 * @author 伊向阳
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		for(int i=0;i<elements.length;i++){
			Integer value = i+1;
			InvocationHandler handler = new ProxyTest().new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{ Comparable.class}, handler);
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length)+1;
		System.out.println("key:"+key);
		int result = Arrays.binarySearch(elements, key);
		System.out.println("result:"+result);
		if(result >=0){
			System.out.println("sssssssss:"+elements[result]);
		}
		

	}
	class TraceHandler implements InvocationHandler{
		private Object target;
		//改方法的隐式参数
		public TraceHandler(Object t) {
			target = t;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.print(target);
			System.out.print("."+method.getName()+"(");
			if(args != null){
				for(int i=0;i<args.length;i++){
					System.out.print(args[i]);
					if(i<args.length-1){
						System.out.print(",");
					}
				}
			}
			System.out.println(")");
			return method.invoke(target, args);
		}
		
	}
}
