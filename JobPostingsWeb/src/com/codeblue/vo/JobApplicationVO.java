package com.codeblue.vo;

public class JobApplicationVO {
	
	private String jobApplicationId;
	private String postingName;
	private String state;
	private  String enterpriseName;
	
	public String getPostingName() {
		return postingName;
	}
	public void setPostingName(String postingName) {
		this.postingName = postingName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(String jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

}
