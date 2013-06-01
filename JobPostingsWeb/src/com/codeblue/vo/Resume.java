package com.codeblue.vo;

public class Resume {
	private String studentId;
	private String[] majorCourse;
	private String[] interests;
	private String[] honors;
	private String[] experience;
	private String resume;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String[] getMajorCourse() {
		return majorCourse;
	}
	public void setMajorCourse(String[] majorCourse) {
		this.majorCourse = majorCourse;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public String[] getHonors() {
		return honors;
	}
	public void setHonors(String[] honors) {
		this.honors = honors;
	}
	public String[] getExperience() {
		return experience;
	}
	public void setExperience(String[] experience) {
		this.experience = experience;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
}
