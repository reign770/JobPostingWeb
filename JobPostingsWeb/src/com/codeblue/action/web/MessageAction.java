package com.codeblue.action.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.codeblue.model.JobInvitation;
import com.codeblue.model.Student;
import com.codeblue.service.student.JobInvitationService;
import com.codeblue.service.student.MessageService;
import com.codeblue.util.PageBean;
import com.codeblue.util.PageBeanTest;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class MessageAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7278287146286750052L;
	
	private int pageSize ;
	private Map<String, Object> session;
	private int pageNumber;
	private MessageService messageService;
	private JobInvitationService jobInvitationService;
	private PageBean pageBean;
	@Override
	public String execute() throws Exception {
		
		String studentId =  ((Student)session.get("student")).getStudentId();
		pageBean = jobInvitationService
				.getUnProcessInvitations(studentId, pageNumber, pageSize);
		pageSize = 1;
		
		return SUCCESS;
	}
	
	public String unprocessInvitations() {
		String studentId =  ((Student)session.get("student")).getStudentId();
		pageBean = jobInvitationService
				.getUnProcessInvitations(studentId, pageNumber, pageSize);
		return "item";
	}
	
	
	public String ingoredInvitations() {
		String studentId =  ((Student)session.get("student")).getStudentId();
		pageBean = jobInvitationService
				.getIngoredJobInvitations(studentId, pageNumber, pageSize);
		return "item";
	}
	
	public String acceptedInvitations() {
		String studentId =  ((Student)session.get("student")).getStudentId();
		pageBean = jobInvitationService
				.getAcceptedJobInvitations(studentId, pageNumber, pageSize);
		return "item";
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@JSON(deserialize=true)
	public MessageService getMessageService() {
		return messageService;
	}
	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	

	public JobInvitationService getJobInvitationService() {
		return jobInvitationService;
	}
	@Resource
	public void setJobInvitationService(JobInvitationService jobInvitationService) {
		this.jobInvitationService = jobInvitationService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
