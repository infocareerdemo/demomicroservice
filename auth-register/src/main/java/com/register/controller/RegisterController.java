package com.register.controller;

import java.security.Principal;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.dto.Users;
import com.register.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@PostMapping("/user")
	public Users createUser(@RequestBody Users users) {
		return registerService.createUser(users);
	}

	@GetMapping("/getUser")
	public UserRepresentation getUser(Principal principal) {
		return registerService.getUserById(principal.getName());
	}

	@DeleteMapping("/id/{id}")
	public void deleteUserById(String id) {
		registerService.deleteUserById(id);
	}
}
