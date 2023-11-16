package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("user-home")
	@RolesAllowed("user")
	public String homeController() {
		
		return "Your Authendicated For Home Service";
	}

}
