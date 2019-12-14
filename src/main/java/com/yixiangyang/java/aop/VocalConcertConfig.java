package com.yixiangyang.java.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
//@ComponentScan(basePackages = {"com.yixiangyang.java.aop"})
public class VocalConcertConfig {

    @Bean
    public VocalConcert vocalConcert() {
        return new VocalConcert();
    }

}