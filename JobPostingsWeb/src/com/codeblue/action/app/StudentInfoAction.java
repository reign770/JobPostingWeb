package com.codeblue.action.app;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

import com.codeblue.service.student.StudentInfoService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.Status;
import com.codeblue.vo.StudentVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("app_studentInfoAction")
public class StudentInfoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6336607918527414478L;
	public final static String SUCCEED = "succeed";
	public final static String FAIL = "fail";
	
	private String username;//学生账号
	private String studentId;//学生学号
	private String password;//密码
	private Status status = new Status();//状态
	private StudentVO studentVO;//学生值对象
	
	private StudentInfoService studentInfoService;
	
	public String login() {
		int flag =
		studentInfoService.validLogin(username, password);
		if(flag == 1) {
			status.setStatus(SUCCEED);
		}
		else {
			status.setStatus(FAIL);
		}
		return "result";
	}
	
	public String showInfo() {
		studentVO = VOUntil.convertToStudentVO(
				studentInfoService.getStudent(studentId));
		
		return "studentInfo";
	}
	
	public String modifyPassword(){
		studentInfoService.modifyPassword(username, password);
		status.setStatus(SUCCEED);
		return "result";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public StudentVO getStudentVO() {
		return studentVO;
	}
	
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	@Resource
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
	
	
	
	

}
