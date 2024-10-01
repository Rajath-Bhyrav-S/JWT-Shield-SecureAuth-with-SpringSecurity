package com.example.Security.SpringSecurity.Service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Security.SpringSecurity.Model.Users;
import com.example.Security.SpringSecurity.Repo.UserRepo;

@Service
public class UserService 
{
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	AuthenticationManager authmanager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	public Users register(Users user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	public String verify(Users user) 
	{
		org.springframework.security.core.Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authentication.isAuthenticated()) {
            return jwtService.generateTocken(user.getUsername());
        } else {
            return "fail";
	}

}
}
