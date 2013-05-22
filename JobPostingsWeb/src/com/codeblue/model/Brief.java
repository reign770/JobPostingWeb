package com.codeblue.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Brief {
	private String studentId;
	private String majorCourse;
	private String interests;
	private String honor;
	private String experience;
	private String resume;//个人简介
	private Student student;
	@Id
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMajorCourse() {
		return majorCourse;
	}
	public void setMajorCourse(String majorCourse) {
		this.majorCourse = majorCourse;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@OneToOne(optional=false)
	@PrimaryKeyJoinColumn
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Brief [studentId=" + studentId + ", majorCourse=" + majorCourse
				+ ", interests=" + interests + ", honor=" + honor
				+ ", experience=" + experience + ", resume=" + resume
				+ "]";
	}
	
}
