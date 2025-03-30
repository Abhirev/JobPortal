package com.abhi.jobportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="job")
public class Job {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String postTitle;
	private String postDesc;
	private int reqExperience;
	private int salary;
	private String companyName;
	private String location;
	
	
	public Job(int postId, String postTitle, String postDesc, int reqExperience, int salary, String companyName,
			String location) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.salary = salary;
		this.companyName = companyName;
		this.location = location;
	}
	
	public Job() {
		
	}
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	public int getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(int reqExperience) {
		this.reqExperience = reqExperience;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	
}