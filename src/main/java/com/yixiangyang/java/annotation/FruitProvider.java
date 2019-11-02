package com.yixiangyang.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitProvider {
	/**
	 * 供应商编号
	 * @return
	 */
	public int id() default -1;
	
	/**
	 * 供应商名字
	 * @return
	 */
	public String name() default "";
	
	/**
	 * 供应商地址
	 * @return
	 */
	public String address() default "";
}
