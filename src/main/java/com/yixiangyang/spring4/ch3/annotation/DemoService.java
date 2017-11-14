package com.yixiangyang.spring4.ch3.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public void outputResult(){
		System.out.println("从组合配置注解中照样获得bean");
	}
}
