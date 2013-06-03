package com.codeblue.vo;

public class JobInvitationVO {
	private String jobInvitationId;
	private String recruitmentId;
	private String postingName;
	private String enterpriseName;
	private String workingPlace;
	private String salary;
	private String enterpriseLogo;
	
	public String getJobInvitationId() {
		return jobInvitationId;
	}
	public void setJobInvitationId(String jobInvitationId) {
		this.jobInvitationId = jobInvitationId;
	}
	public String getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(String recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getPostingName() {
		return postingName;
	}
	public void setPostingName(String postingName) {
		this.postingName = postingName;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEnterpriseLogo() {
		return enterpriseLogo;
	}
	public void setEnterpriseLogo(String enterpriseLogo) {
		this.enterpriseLogo = enterpriseLogo;
	}
	@Override
	public String toString() {
		return "JobInvitationVO [jobInvitationId=" + jobInvitationId
				+ ", recruitmentId=" + recruitmentId + ", postingName="
				+ postingName + ", enterpriseName=" + enterpriseName
				+ ", workingPlace=" + workingPlace + ", salary=" + salary
				+ ", enterpriseLogo=" + enterpriseLogo + "]";
	}
	
	

}
