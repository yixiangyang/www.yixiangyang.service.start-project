package com.yixiangyang.spring4.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {
	
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService WindowsListService(){
		return new WindowsListService();
	}
}
