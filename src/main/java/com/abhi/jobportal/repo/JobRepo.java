package com.abhi.jobportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.abhi.jobportal.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{
	
	public List<Job> findByPostTitleContainingOrPostDescContainingOrCompanyNameContaining(String query1,String query2,String query3);

}