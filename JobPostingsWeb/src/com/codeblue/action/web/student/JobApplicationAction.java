package com.codeblue.action.web.student;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.Session;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Student;
import com.codeblue.service.student.JobApplicationService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("jobApplicationAction")
public class JobApplicationAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6562503473379376265L;
	
	private String studentId;
	private int recruitmentId;
	private String content;
	private JobApplicationService jobApplicationService;
	private String message;
	private Map<String, Object> session;
	public String applyJob() {
		String id = ((Student)session.get("student")).getStudentId();
		jobApplicationService.applyPosting(id, recruitmentId, content);
		message="apply_success";
		return SUCCESS;
	}
	@JSON(serialize=false)
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	@JSON(serialize=false)
	public int getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	@JSON(serialize=false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@JSON(serialize=true)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@JSON(serialize=false)
	public JobApplicationService getJobApplicationService() {
		return jobApplicationService;
	}
	@Resource
	public void setJobApplicationService(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
	
}
