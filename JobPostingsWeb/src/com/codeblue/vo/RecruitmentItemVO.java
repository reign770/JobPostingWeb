package com.codeblue.vo;

public class RecruitmentItemVO {
	private String recruitmentId;
	private String enterpriseId;
	private String enterpriseName;
	private String postingName;
	private String workingPlace;
	private String salary;
	private String enterpriseLogo;
	public String getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(String recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getPostingName() {
		return postingName;
	}
	public void setPostingName(String postingName) {
		this.postingName = postingName;
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
		return "RecruitmentItemVO [recruitmentId=" + recruitmentId
				+ ", enterpriseId=" + enterpriseId + ", enterpriseName="
				+ enterpriseName + ", postingName=" + postingName
				+ ", workingPlace=" + workingPlace + ", salary=" + salary
				+ ", enterpriseLogo=" + enterpriseLogo + "]";
	}
	

}
