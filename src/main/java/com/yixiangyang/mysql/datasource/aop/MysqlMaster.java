package com.yixiangyang.mysql.datasource.aop;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//表示使用在哪里，FIELD:成员变量、对象、属性（包括enum实例,用于描述方法 Method
@Retention(RUNTIME)//表示使用的声明周期 ，RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
@Documented// –注解是否将包含在JavaDoc中
public @interface MysqlMaster {

}
