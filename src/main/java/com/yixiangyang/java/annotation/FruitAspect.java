package com.yixiangyang.java.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
public class FruitAspect {
	
	//@Pointcut("execution(com.yixiangyang.java.annotation.Apple.getAppleName())")
	@Pointcut("execution(* com.yixiangyang.java.annotation.Apple.getAppleName(..))")
	public void poincut(){
		System.out.println("这个是一个公共的切点");
	}
	
	@Before("poincut()")
	public void poinBefore(){
		System.out.println("开始前");
	}
	
	@After("execution(* com.yixiangyang.java.annotation.Apple.getAppleName())")
	public void aaa(){
		System.out.println("之后");
	}
	
	@Pointcut("this(com.yixiangyang.java.annotation.Apple)")
	public void poincut1(){
		
	}
	
	@After("poincut1()")
	public void before(JoinPoint joinPoint){
		Apple add = (Apple) joinPoint.getTarget();
		System.out.println("dddddddddddddddd"+add.getAppleName()+"jjjjjjjjjjjjjj");
		if(add.getAppleName().length()>2){
			try {
				throw new Exception("过长");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("-------------"+joinPoint.getTarget());
		System.out.println(joinPoint.getArgs().toString());
		System.out.println(joinPoint.getThis());
		System.out.println("这个是对象参数");
	}
}
