package com.example.Security.SpringSecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Security.SpringSecurity.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>
{
	Users findByUsername(String username);
}
