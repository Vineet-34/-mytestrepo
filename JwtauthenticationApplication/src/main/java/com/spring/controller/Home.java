package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	//@RequestMapping("/welcome")
	@GetMapping("/welcome")
	public String welcome() {
		String text = "Welcome to JWT JAVA WEB TOKENS..";
		

		return text;
	}
	
	@GetMapping("/getusers")
	public String getUser() {
	
		return "{\"name\":\"Vineet\"}";
}
}
 