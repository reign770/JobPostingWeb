package com.codeblue.model;

import java.util.Date;
import java.util.concurrent.RecursiveAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobApplication {
	private long applyId;
	private Date applyDate;
	private int state;
	private String content;
	private Student student;
	private Recruitment recruitment;
	@Id
	@GeneratedValue
	public Date getApplyDate() {
		return applyDate;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne
	@JoinColumn(name="studentId")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@ManyToOne
	@JoinColumn(name="recruitmentId")
	public Recruitment getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}
	@Override
	public String toString() {
		return "JobApplication [applyId=" + applyId
				+ ", applyDate=" + applyDate + ", state=" + state
				+ ", content=" + content + ", student=" + student
				+ ", recruitment=" + recruitment + "]";
	}	

}
