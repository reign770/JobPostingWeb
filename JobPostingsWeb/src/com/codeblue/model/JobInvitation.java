package com.codeblue.model;

import java.util.Date;

import javax.persistence.*;
@Entity
public class JobInvitation {
	private long invitationId;
	private Date invitationDate;
	private int state;
	private String content;//内容
	private Student student;
	private Recruitment recruitment;
	@Id
	@GeneratedValue
	public long getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(long invitationId) {
		this.invitationId = invitationId;
	}
	
	public Date getInvitationDate() {
		return invitationDate;
	}
	
	public void setInvitationDate(Date invitationDate) {
		this.invitationDate = invitationDate;
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
		return "JobInvitation [invitationId=" + invitationId
				+ ", invitationDate=" + invitationDate + ", state=" + state
				+ ", content=" + content + ", student=" + student
				+ ", recruitment=" + recruitment + "]";
	}

}
