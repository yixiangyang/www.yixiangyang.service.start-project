package com.yixiangyang.java.annotation;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitColor {
	/**
	 * 颜色枚举
	 * @author 伊向阳
	 *
	 */
	public enum Color{BLUE,RED,GREEN}
	
	Color fruitColor() default Color.RED;
}
