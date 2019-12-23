package com.yixiangyang.java.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =VocalConcertConfig.class)
public class test1 {


    @Autowired
    Song mm;
    
//    ManMan ma;
synchronized
    @Test
    public void log() {
        mm.song();
//        ManMan man = new ManMan();
//        man.song();
    }

}