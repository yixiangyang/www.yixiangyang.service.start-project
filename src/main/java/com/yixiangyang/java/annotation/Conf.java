package com.yixiangyang.java.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Conf {
	
	@Bean
	public FruitAspect fruit(){
		System.out.println("aaa");
		return new FruitAspect();
	}
	
	/*@Bean
	public Apple app(){
		System.out.println(new Apple().getAppleName());
		return new Apple();
	}*/
}
