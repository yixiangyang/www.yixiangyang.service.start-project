package com.yixiangyang.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableUtcConfig
//@RestController
@SpringBootApplication
public class Application {

	/*@Value("${book.author}")
	private String bookAuthor;
	
	@Value("${book.name}")
	private String bookName;
	
	@RequestMapping("/")
	String index(){
		return "这是本书的作者是"+bookAuthor+"书名是"+bookName;
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
