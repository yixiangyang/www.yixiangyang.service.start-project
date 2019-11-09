package com.yixiangyang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yixiangyang.mapper.UserMapper;
import com.yixiangyang.model.User;
import com.yixiangyang.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public void addUser() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(new Supplier<List<String>>() {

			@Override
			public List<String> get() {
				Date createTime = new Date(System.currentTimeMillis());
				for (int i = 0; i < 10000; i++) {
					User user = new User("测试名字"+i, createTime);
					userMapper.inserUser(user);
				}
				return null;
			}
			
		},executor);
		if(future1.isDone()) {
			executor.shutdown();
		}
	}

}
