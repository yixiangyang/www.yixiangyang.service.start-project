package com.yixiangyang.application;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yixiangyang.service.UserService;

//@EnableUtcConfig
@RestController
@SpringBootApplication
//@ComponentScan(basePackages={"com.yixiangyang.java.annotation"})
@ComponentScan(basePackages = { "com.yixiangyang.controller", "com.yixiangyang.service","com.yixiangyang.java.annotation" })
@MapperScan(basePackages= {"com.yixiangyang.mapper"})
public class Application {

	/*@Value("${book.author}")
	private String bookAuthor;
	
	@Value("${book.name}")
	private String bookName;
	*/
	@RequestMapping("/dd")
	String index(){
		return "这是本书的作者是"+"书名是";
	}
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/v1/aa")
	public String getTest(){
		userService.addUser();
		return "aaa";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
