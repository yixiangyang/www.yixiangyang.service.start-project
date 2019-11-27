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

import com.yixiangyang.java.util.Column;
import com.yixiangyang.java.util.ExcelUtil;
import com.yixiangyang.java.util.ExcelUtil1;
import com.yixiangyang.java.util.Line;
import com.yixiangyang.mapper.UserMapper;
import com.yixiangyang.model.EmpLogin;
import com.yixiangyang.model.User;
import com.yixiangyang.mysql.datasource.aop.MysqlMaster;
import com.yixiangyang.mysql.datasource.aop.MysqlSlave;
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

	@Override
	public void exportUserLogin() {
		List<EmpLogin> list = userMapper.searchUserLogin();
		List<String> headerList = new ArrayList<>();
		headerList.add("id");
		headerList.add("userNo");
		headerList.add("userName");
		List<Line> lines = new ArrayList<>();
		for(EmpLogin e:list) {
			List<Column> columns = new ArrayList<>();
			columns.add(new Column("id", e.getId()));
			columns.add(new Column("userNo", e.getUserNo()));
			columns.add(new Column("userName", e.getUserName()));
			Line line = new Line();
			line.setColumns(columns);
			lines.add(line);
		}
		ExcelUtil1.exportExcel(headerList, lines, "", "用户登录的数据");
		
	}

	@Override
//	@MysqlSlave
	public List<User> getUsers() {
		List<User> users = userMapper.getUsers();
		return users;
	}

	@Override
	@MysqlSlave
	public List<User> getSlave() {
		List<User> users = userMapper.getUsers();
		//userMapper.searchUserLogin();
//		userMapper2.selectAll();
		return users;
	}

}
