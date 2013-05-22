package com.codeblue.model;


import javax.persistence.*;
@Entity
public class Class {
	private int classId;
	private String className;
	private int grade;//年级
	private Major major;
	@Id
	@GeneratedValue
	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="majorId")
	public Major getMajor() {
		return major;
	}
	
	public void setMajor(Major major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className
				+ ", grade=" + grade + ", major=" + major + "]";
	}
}
