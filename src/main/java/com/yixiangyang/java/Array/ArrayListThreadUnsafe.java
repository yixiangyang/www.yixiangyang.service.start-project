package com.yixiangyang.java.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试ArrayList线程不安全
 * 线程不安全导致的原因是：
 * 并发争抢导致，一个list正在写入，另一个也来发生争夺而导致的
 * 
 * 解决方案
 * 1、Vector线程安全
 * 2、Collections.synchronizedList(new ArrayList<String>());
 * 3、new CopyOnWriteArrayList<>()
 * 当发生线程不安全的时候 会抛出一个 java.util.ConcurrentModificationException 并发修改异常
 */
public class ArrayListThreadUnsafe {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();//线程不安全
        
//    	List<String> list =  new Vector<String>(); //线程安全
        List<String> list3 = Collections.synchronizedList(new ArrayList<String>());//搞一个加锁的list将不安全的list 放到安全的list里
        List<String> list4 = new CopyOnWriteArrayList<>();
        for (int i=0;i<3000;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list.toString());
            }).start();
        }
    }
}
