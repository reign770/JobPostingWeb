package com.codeblue.action.web;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Student;
import com.codeblue.service.student.MessageService;
import com.codeblue.service.student.StudentInfoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class StudentLoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 5866130959644997509L;
	
	private String account;
	private String password;
	private Map<String,Object> session;
	private String loginmessage;
	private long unreadedNumber;
	
	private MessageService messageService;
	private StudentInfoService studentInfoService;

	@Override
	public String execute() throws Exception {
		if(session.get("student") != null) {
			Student student = (Student)session.get("student");
			unreadedNumber = messageService
					.getUnreadedNotifications(student.getStudentId(), 1, 1).getAllRow();
			return Action.SUCCESS;
		}
		else {
			return Action.LOGIN;
		}
	}
	
	public String validateInfo() {
		int loginState = 
				studentInfoService.validLogin(account, password); 
		if( loginState == 1) {
			session.put("student", 
					studentInfoService.getStudent(account));
			loginmessage = "login_success";
		} else if (loginState == 2) {
			loginmessage = "noaccount";
		} else if (loginState == 3){
			loginmessage = "wrongpassword";
		} else {
			loginmessage = "disable";
		}
		return "validate";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@JSON(serialize=false)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JSON(serialize=true)
	public String getLoginmessage() {
		return loginmessage;
	}


	public void setLoginmessage(String loginmessage) {
		this.loginmessage = loginmessage;
	}
	
	@JSON(serialize=false)
	public long getUnreadedNumber() {
		return unreadedNumber;
	}

	public void setUnreadedNumber(long unreadedNumber) {
		this.unreadedNumber = unreadedNumber;
	}

	@JSON(serialize=false)
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	@Resource
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
	@JSON(serialize=false)
	public MessageService getMessageService() {
		return messageService;
	}
	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	
	
	
	

}
