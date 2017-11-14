package com.yixiangyang.spring4.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.yixiangyang.spring4.ch3.taskscheduler")
//使用下面注解开启对计划任务的支持
@EnableScheduling
public class TaskScheduledConfig {

}
