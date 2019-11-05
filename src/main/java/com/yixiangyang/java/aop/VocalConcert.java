package com.yixiangyang.java.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class VocalConcert {
	@Pointcut("execution(* com.yixiangyang.java.aop.Song.song(..))")
    public void doing() {
		System.out.println("正在做");
    }

    @Before("doing()")
    public void checking() {
        System.out.println("切面开始的时候");
    }

    @AfterReturning("doing()")
    public void beautiful() {
        System.out.println("演唱会进入精彩部分的时候,鼓掌！");
    }

    @AfterReturning("doing()")
    public void leave() {
        System.out.println("结束后，我们离开场地");
    }
}
