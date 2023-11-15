package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	

    @GetMapping("/emp")
    public String getEmp() {  
        String result = restTemplate.getForObject("http://ADDRESS/address/ads", String.class);
//         String result = restTemplate.getForObject("http://localhost:8084/address/ads", String.class);       
             return  result;
    }
    
    
    @GetMapping("emp-test")
    public String getTest() {
    	String result = restTemplate.getForObject("http://ADDRESS/address/tst", String.class);
    	   return result;
    }

}
