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
public class InvitationAction extends ActionSupport implements SessionAware{
	
	public static final String JSON_RESULT = "json_result";
	/**
	 * 
	 */
	private static final long serialVersionUID = -7278287146286750052L;
	
	private int pageSize ;
	private Map<String, Object> session;
	private int pageNumber;
	private String content;
	private MessageService messageService;
	private JobInvitationService jobInvitationService;
	private PageBean pageBean;
	private long invitationId;
	private String message;
	
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
	
	public String accept() {
		content = content.trim();
		int flag = jobInvitationService.acceptJobInvitation(invitationId,content);
		System.err.println("flag:"+flag);
		//判断是否接受邀请成功
		if(flag == 1){
			message = "accept_success";
		}
		else {
			System.err.println("ignore");
			jobInvitationService.ingoreJobInvitation(invitationId);
			message = "accept_fail";
		}
		return JSON_RESULT;
	}
	
	public String ignore() {
		System.err.println("ignore");
		jobInvitationService.ingoreJobInvitation(invitationId);
		message = "ignore_success";
		return JSON_RESULT;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@JSON(serialize=false)
	public MessageService getMessageService() {
		return messageService;
	}
	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@JSON(serialize=false)
	public JobInvitationService getJobInvitationService() {
		return jobInvitationService;
	}
	@Resource
	public void setJobInvitationService(JobInvitationService jobInvitationService) {
		this.jobInvitationService = jobInvitationService;
	}
	
	@JSON(serialize=true)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JSON(serialize=false)
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	@JSON(serialize=false)
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	@JSON(serialize=false)
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@JSON(serialize=false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@JSON(serialize=false)
	public long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(long invitationId) {
		this.invitationId = invitationId;
	}
	
	
	

}
