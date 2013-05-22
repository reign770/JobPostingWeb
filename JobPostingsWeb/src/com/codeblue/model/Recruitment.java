package com.codeblue.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Recruitment {
	private int recruitmentId;
	private int state;
	private String postingName;
	private int recruitmentCount;
	private String workingPlace;
	private int salary;
	private String sex;
	private String workExperience;
	private String age;//年龄要求
	private String foreignLanguage;//外语要求
	private String degree;//学历要求
	private String responsibilities;
	private String qualification;
	private Date deadline;
	private Date releaseDate;
	private Enterprise enterprise;//发布该信息的企业
	private Industry industry;//招聘所属行业
	@Id
	@GeneratedValue
	public int getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getPostingName() {
		return postingName;
	}
	public void setPostingName(String postingName) {
		this.postingName = postingName;
	}
	public int getRecruitmentCount() {
		return recruitmentCount;
	}
	public void setRecruitmentCount(int recruitmentCount) {
		this.recruitmentCount = recruitmentCount;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getForeignLanguage() {
		return foreignLanguage;
	}
	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@ManyToOne
	@JoinColumn(name="enterpriseId")
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	@ManyToOne
	@JoinColumn(name="industryId")
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Recruitment [recruitmentId=" + recruitmentId + ", state="
				+ state + ", postingName=" + postingName
				+ ", recruitmentCount=" + recruitmentCount + ", workingPlace="
				+ workingPlace + ", salary=" + salary + ", sex=" + sex
				+ ", workExperience=" + workExperience + ", age=" + age
				+ ", foreignLanguage=" + foreignLanguage + ", degree=" + degree
				+ ", responsibilities=" + responsibilities + ", qualification="
				+ qualification + ", deadline=" + deadline + ", releaseDate="
				+ releaseDate + ", enterprise=" + enterprise + ", industry="
				+ industry + "]";
	}
	
}
