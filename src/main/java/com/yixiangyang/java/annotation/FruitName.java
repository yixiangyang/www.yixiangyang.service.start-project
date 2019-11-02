package com.yixiangyang.java.annotation;
/**
 * 测试使用元注解
 * @author 伊向阳
 *
 */
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)//表示使用在哪里，FIELD:成员变量、对象、属性（包括enum实例
@Retention(RUNTIME)//表示使用的声明周期 ，RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
@Documented// –注解是否将包含在JavaDoc中
public @interface FruitName {
	String value() default "";
}
