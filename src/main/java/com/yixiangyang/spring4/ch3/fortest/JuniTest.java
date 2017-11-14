/*package com.yixiangyang.spring4.ch3.fortest;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})//用来加载ApplicationContext配置类
@ActiveProfiles("dev")//用来声明活动的profile (轮廓)
public class JuniTest {
	@Resource
	private TestBean testBean;
	
	@Test
	public void prodBeanShouldInject(){
		String expected = "from development profile";
		String actual = testBean.getContext();
		Assert.assertEquals(expected,actual);
	}
}
*/