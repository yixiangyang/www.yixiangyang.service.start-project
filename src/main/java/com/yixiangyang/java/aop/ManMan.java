package com.yixiangyang.java.aop;

import org.springframework.stereotype.Component;

@Component
public class ManMan implements Song {

    public void song() {
        System.out.println("下面这首歌是张学友的《慢慢》");
    }
}