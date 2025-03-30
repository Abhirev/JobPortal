package com.abhi.jobportal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.jobportal.model.Job;
import com.abhi.jobportal.repo.JobRepo;

@Service
public class jobService {

	List<Job> jobs = new ArrayList<>(Arrays.asList(
            new Job(1, "Software Engineer", "Develop and maintain applications", 2, 60000, "TechCorp", "New York"),
            new Job(2, "Data Analyst", "Analyze business data and generate insights", 3, 55000, "Data Solutions", "San Francisco"),
            new Job(3, "Frontend Developer", "Build UI components and improve UX", 1, 50000, "WebWorks", "Los Angeles"),
            new Job(4, "DevOps Engineer", "Manage CI/CD pipelines and cloud infrastructure", 4, 70000, "CloudOps Inc.", "Seattle"),
            new Job(5, "Cybersecurity Analyst", "Monitor security threats and vulnerabilities", 2, 65000, "SecureNet", "Washington D.C.")
        ));
	
	@Autowired
	private JobRepo repo;
	
	public List<Job> getJobs(){
		return repo.findAll();
	}

	public void load() {
		repo.saveAll(jobs);
	}

	public Job addJob(Job job) {
		return repo.save(job);
	}

	public Job getJob(int postId) {
		
		return repo.findById(postId).orElse(new Job());
	}

	public List<Job> searchJob(String query) {		
		return repo.findByPostTitleContainingOrPostDescContainingOrCompanyNameContaining(query, query, query);
	}
	
	
}
