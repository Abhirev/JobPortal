package com.abhi.jobportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class JobApplication {

	@Id
	Long jobId;
	Long userId;
	 private String additionalNotes;
	    
	    @Lob
	    private byte[] resume;
	public JobApplication() {
		
	}
	public JobApplication(Long jobId, Long userId, String additionalNotes, byte[] resume) {
		super();
		this.jobId = jobId;
		this.userId = userId;
		this.additionalNotes = additionalNotes;
		this.resume = resume;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	
	
}
