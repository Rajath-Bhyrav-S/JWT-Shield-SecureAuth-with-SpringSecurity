package com.example.Security.SpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Security.SpringSecurity.Model.Users;
import com.example.Security.SpringSecurity.Service.UserService;

@RestController
public class UserController 
{
	
	@Autowired
	private UserService service;
	@PostMapping("/register")
	public Users register(@RequestBody Users user)
	{
		return service.register(user);
	}
	

}
