/*package com.yixiangyang.spring4.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
		for(int i=0 ;i<10;i++){
			taskService.executeAsyncTask(i);
			taskService.executeAsyncTaskPlus(i);
		}
		context.close();
	}

}
*/