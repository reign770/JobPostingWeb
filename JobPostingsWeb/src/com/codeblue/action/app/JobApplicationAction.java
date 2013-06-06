package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.student.JobApplicationService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.JobApplicationVO;
import com.codeblue.vo.Status;
import com.opensymphony.xwork2.ActionSupport;


@Controller("app_jobApplication")
public class JobApplicationAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -600480002487492522L;
	public static final int pageSize = 10;
	//参数
	private String studentId;
	private int recruitmentId;
	private int pageParam;
	//返回参数
	private List<JobApplicationVO> jobApplicationVOs;
	private Status status;
	//注入数据
	private JobApplicationService jobApplicationService;
	
	public String showJobApplications() {
		jobApplicationVOs = VOUntil.convertToJobApplicationVOs(
				jobApplicationService
				.getAllJobApplication(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	public String applyJob() {
		int flag =jobApplicationService.applyPosting(studentId, recruitmentId, "我申请你们的职位");
		status = new Status();
		status.setStatus("succeed");
		return "result";
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public int getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public int getPageParam() {
		return pageParam;
	}
	public void setPageParam(int pageParam) {
		this.pageParam = pageParam;
	}
	public List<JobApplicationVO> getJobApplicationVOs() {
		return jobApplicationVOs;
	}
	public void setJobApplicationVOs(List<JobApplicationVO> jobApplicationVOs) {
		this.jobApplicationVOs = jobApplicationVOs;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public JobApplicationService getJobApplicationService() {
		return jobApplicationService;
	}
	@Resource
	public void setJobApplicationService(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
	
	

}
