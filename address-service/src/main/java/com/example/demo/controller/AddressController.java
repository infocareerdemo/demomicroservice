package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	@GetMapping("/ads")
	public String getAddress() {
		return "Address";
	}

	@GetMapping("/tst")
	public String getTest() {
		return "Test";
	}
}
