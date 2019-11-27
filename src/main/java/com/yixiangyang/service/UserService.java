package com.yixiangyang.service;

import java.util.List;

import com.yixiangyang.model.User;

public interface UserService {
	public void addUser();
	
	public void exportUserLogin();
	
	public List<User> getUsers();
	
	public List<User> getSlave();
}
