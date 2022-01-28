package com.microservices.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.example.entiry.User;
import com.microservices.example.service.UserService;
import com.microservices.example.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		System.out.println("Inside the Save User");
		return userService.save(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable Long  userId) {
		System.out.println("Inside the getUserWithDepartment");

		return userService.getUserWithDepartment(userId);
	}
}
