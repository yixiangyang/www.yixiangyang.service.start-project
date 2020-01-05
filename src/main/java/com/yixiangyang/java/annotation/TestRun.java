package com.yixiangyang.java.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
public class TestRun {
	@Resource
	private Apple a;
	@Test
	public void aa(){
		//System.out.println(app.getAppleName());
		
		a.setAppleName("这个是名字");
		System.out.println(a.getAppleName());
	}
}
