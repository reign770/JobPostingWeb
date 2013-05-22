package com.codeblue.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Notification {
	private long notificationId;
	private int state;
	private String content;
	private Date postTime;
	private String studentId;
	private Enterprise enterprise;
	@Id
	@GeneratedValue
	public long getNotificationId() {
		return notificationId;
	}
	
	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
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

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@ManyToOne
	@JoinColumn(name="enterpriseId")
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enterprise == null) ? 0 : enterprise.hashCode());
		result = prime * result
				+ (int) (notificationId ^ (notificationId >>> 32));
		result = prime * result
				+ ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (enterprise == null) {
			if (other.enterprise != null)
				return false;
		} else if (!enterprise.equals(other.enterprise))
			return false;
		if (notificationId != other.notificationId)
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", state="
				+ state + ", content=" + content + ", postTime=" + postTime
				+ ", studentId=" + studentId + ", enterprise=" + enterprise
				+ "]";
	}
	
}
