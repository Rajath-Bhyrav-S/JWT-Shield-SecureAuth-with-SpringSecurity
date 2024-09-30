package com.example.Security.SpringSecurity.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Security.SpringSecurity.Model.UserPrincipal;
import com.example.Security.SpringSecurity.Model.Users;
import com.example.Security.SpringSecurity.Repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername (String username)throws UsernameNotFoundException
	{
		Users user = repo.findByUsername(username);
		if(user == null)
		{
			System.out.println("Users not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}

}
