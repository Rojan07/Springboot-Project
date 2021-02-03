package com.example.teacher.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teacher.teacher.model.User;
import com.example.teacher.teacher.repo.UserRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public String addUserByAdmin(@RequestBody User user) {
			String pwd=user.getPassword();
			String encryptpw=passwordEncoder.encode(pwd);
			user.setPassword(encryptpw);
		userrepo.save(user);
		return "User added successfully";

	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	

}
