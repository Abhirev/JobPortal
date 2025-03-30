package com.abhi.jobportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.jobportal.model.JobApplication;

public interface JobAppRepo extends JpaRepository<JobApplication,Integer>{

}
