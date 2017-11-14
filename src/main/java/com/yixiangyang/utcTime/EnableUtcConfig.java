package com.yixiangyang.utcTime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
@Configuration
@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({UtcConfig.class})
//@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)  
public @interface EnableUtcConfig {

}
