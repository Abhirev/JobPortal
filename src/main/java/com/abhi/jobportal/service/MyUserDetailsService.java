package com.abhi.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.abhi.jobportal.model.User;
import com.abhi.jobportal.model.UserPrincipal;
import com.abhi.jobportal.repo.UserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo urepo;
	
	private User user; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user = urepo.findByUsername(username);
		
		if(user == null) {
			System.out.println("User 404");
			return null;
		}
		return new UserPrincipal(user);
	}
	
	
	public String getUserRole() {
		return user.getRoles();
	}
	

}
