package com.codeblue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
	private int departmentId;
	private String departmentName;
	private String departmentInfo;
	@Id
	@GeneratedValue
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentInfo() {
		return departmentInfo;
	}
	
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", departmentInfo=" + departmentInfo + "]";
	}
	
	
	
}
