package com.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.LoginRequest;
import com.auth.service.LoginService;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Map<String, String> login){
		return new ResponseEntity<Object>(loginService.login(login),HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Object> logout(@RequestBody Map<String, String> token){
		return new ResponseEntity<Object>(loginService.logout(token),HttpStatus.OK);
	} 

}
