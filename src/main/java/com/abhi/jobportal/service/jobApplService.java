package com.abhi.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.jobportal.model.JobApplication;
import com.abhi.jobportal.repo.JobAppRepo;

@Service
public class jobApplService {

	@Autowired
	private JobAppRepo repo;
	
	public void add(JobApplication request) {
		repo.save(request);
	}

	
}
