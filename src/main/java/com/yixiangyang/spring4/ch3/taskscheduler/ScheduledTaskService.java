package com.yixiangyang.spring4.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("每隔五秒执行一次"+dateFormat.format(new Date()));
	}
	
	@Scheduled(cron="0 20 14 ? * *")//使用cron来配置按照指定时间执行 每天的十四点二十分来执行
	public void fixTimeExecution(){
		System.out.println("在指定时间内执行"+dateFormat.format(new Date()));
	}
}
