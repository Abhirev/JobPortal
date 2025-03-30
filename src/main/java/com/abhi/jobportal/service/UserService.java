package com.abhi.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhi.jobportal.model.User;
import com.abhi.jobportal.repo.UserRepo;

@Service
public class UserService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	
	@Autowired
	private UserRepo repo;
	
	public User userRegister(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public String getUserRole(User user) {
		User u = repo.findByUsername(user.getUsername());
		if(u!=null) {
			return u.getRoles();
		}
		else
			return (new User()).getRoles();
	}
}
