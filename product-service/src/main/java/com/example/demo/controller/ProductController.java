package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/user-product")
	@RolesAllowed("user")
	public String productController() {
		return "Your Aunthedicated For Product Service";
	}


}
