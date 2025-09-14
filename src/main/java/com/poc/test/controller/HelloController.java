package com.poc.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample Controller
 */

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/sayHello")
	public String hello() {
		return "Hello World";
	}

}
