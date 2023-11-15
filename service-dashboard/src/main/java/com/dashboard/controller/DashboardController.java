package com.dashboard.controller;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@GetMapping("/userHome")
	@RolesAllowed("user")
	public String getUserMaessage() {
		return "Welcome User Dashboard";
	}

	@GetMapping("/adminHome")
	@RolesAllowed("admin")
	public String getAdminMaessage() {
		return "Welcome Admin Dashboard";
	}
}
