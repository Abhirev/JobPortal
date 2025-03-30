package com.abhi.jobportal.model;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class UserPrincipal implements UserDetails{
	
	private User user;
	
	public UserPrincipal(User user) {
		this.user = user; 
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return List.of(user.getRoles().split(","))
	            .stream()
	            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim().toUpperCase()))
	            .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
