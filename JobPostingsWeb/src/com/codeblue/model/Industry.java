package com.codeblue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Industry {
	private int industryId;
	private String jobType;
	@Id
	@GeneratedValue
	public int getIndustryId() {
		return industryId;
	}
	
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Override
	public String toString() {
		return "Industry [industryId=" + industryId + ", jobType=" + jobType
				+ "]";
	}
}
