package com.codeblue.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Major {
	private int majorId;
	private String majorName;
	private String majorInfo;
	private Department department;
	@Id
	@GeneratedValue
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorInfo() {
		return majorInfo;
	}
	public void setMajorInfo(String majorInfo) {
		this.majorInfo = majorInfo;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="departmentId")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Major [majorId=" + majorId + ", majorName=" + majorName
				+ ", majorInfo=" + majorInfo + ", department=" + department
				+ "]";
	}
	
	

}
