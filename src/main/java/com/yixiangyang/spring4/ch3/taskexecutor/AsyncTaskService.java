package com.yixiangyang.spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println("执行异步任务"+i);
	}
	
	/**
	 * 加上@Async注解表示该方法是个异步方法 如果加在类上面则表示该类中的所有方法都是异步的
	 * @param i
	 */
	@Async
	public void executeAsyncTaskPlus(Integer i){
		System.out.println("执行异步任务+1"+(i+1));
	}
}
