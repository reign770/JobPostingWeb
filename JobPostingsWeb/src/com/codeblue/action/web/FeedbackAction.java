package com.codeblue.action.web;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Student;
import com.codeblue.service.student.JobApplicationService;
import com.codeblue.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class FeedbackAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private PageBean pageBean;
	private int pageNumber;
	private int pageSize;
	private JobApplicationService jobApplicationService;
	@Override
	public String execute() throws Exception {
		String studentId = ((Student)session.get("student")).getStudentId();
		pageBean = jobApplicationService
				.getAllJobApplication(studentId, pageNumber, pageSize);
		return SUCCESS;
	}

	public String jobapplyfeedback(){
		String studentId = ((Student)session.get("student")).getStudentId();
		pageBean = jobApplicationService
				.getAllJobApplication(studentId, pageNumber, pageSize);
		return "item";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public JobApplicationService getJobApplicationService() {
		return jobApplicationService;
	}
	@Resource
	public void setJobApplicationService(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}

}
