package com.codeblue.action.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.mapping.Array;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Brief;
import com.codeblue.model.Student;
import com.codeblue.service.student.StudentInfoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentInfoAction")
public class StudentInfoAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -1150246590972142316L;
	
	private String studentId;
	private String password;
	private int industryId;
	private Student student;
	private StudentInfoService studentInfoService;
	private Brief brief;
	private Map<String, Object> session;
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String showStudentInfo() {
		if(studentId==null && studentId.equals(""))
			return "nostudent";
		student = studentInfoService.getStudent(studentId);
		if(student==null)
			return "nostudent";
		else {
			return "getinfo";
		}
	}
	public String modifyBrief() {
		studentInfoService.modifyBrief(brief);
		return SUCCESS;
	}
	
	public String modifyPassword() {
		System.err.println("modifypassword");
		studentInfoService.modifyPassword(
				((Student)session.get("student")).getStudentId(), 
				password);
		return "modifypassword_success";
	}
	
	public String modifyJobIntention() {
		studentInfoService.modifyJobIntention(studentId, industryId);
		return SUCCESS;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Brief getBrief() {
		return brief;
	}

	public void setBrief(Brief brief) {
		this.brief = brief;
	}
	
	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	@Resource
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
	
	
	

}
