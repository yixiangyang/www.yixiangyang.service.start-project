package com.yixiangyang.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yixiangyang.service.UserService;

@RestController
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/v1/aa",method = RequestMethod.GET)
	public String getTest(){
//		userService.addUser();
		userService.exportUserLogin();
		return "aaa";
	}
}
