package com.abhi.jobportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.jobportal.model.User;

public interface UserRepo extends JpaRepository<User, String>{

	public User findByUsername(String username);
}
