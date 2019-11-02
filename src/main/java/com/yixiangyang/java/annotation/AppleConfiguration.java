package com.yixiangyang.java.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppleConfiguration {
	
	@Bean
	public Apple apple(){
		return new Apple();
	}
}
