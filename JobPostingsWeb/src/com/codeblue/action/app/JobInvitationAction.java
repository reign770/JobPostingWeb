package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.student.JobInvitationService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.JobInvitationVO;
import com.codeblue.vo.Status;
import com.opensymphony.xwork2.ActionSupport;

@Controller("app_jobInvitation")
public class JobInvitationAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3146263319629601853L;
	public static final int pageSize = 10;
	//参数
	private String studentId;
	private int pageParam;
	private long jonInvitationId;
	//返回数据
	private List<JobInvitationVO> jobInvitationVOs;
	private Status status;
	//
	private JobInvitationService jobInvitationService;
	
	public String getUnprocessInvitations() {
		jobInvitationVOs = VOUntil.convertToJobInvitationVOs(jobInvitationService
				.getUnProcessInvitations(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String getIgnoredInvitations() {
		jobInvitationVOs = VOUntil.convertToJobInvitationVOs(jobInvitationService
				.getIngoredJobInvitations(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String getAcceptedInvitations() {
		jobInvitationVOs = VOUntil.convertToJobInvitationVOs(jobInvitationService
				.getAcceptedJobInvitations(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String accpetInvitation() {
		int flag =
		jobInvitationService.acceptJobInvitation(jonInvitationId, "");
		status = new Status();
		if(flag == 0){
			status.setStatus("failed");
		}
		else {
			status.setStatus("succeed");
		}
		return "result";
	}
	
	public String ignoreInvitation() {
		jobInvitationService.ingoreJobInvitation(jonInvitationId);
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
	public int getPageParam() {
		return pageParam;
	}
	public void setPageParam(int pageParam) {
		this.pageParam = pageParam;
	}
	public long getJonInvitationId() {
		return jonInvitationId;
	}
	public void setJonInvitationId(long jonInvitationId) {
		this.jonInvitationId = jonInvitationId;
	}

	public List<JobInvitationVO> getJobInvitationVOs() {
		return jobInvitationVOs;
	}

	public void setJobInvitationVOs(List<JobInvitationVO> jobInvitationVOs) {
		this.jobInvitationVOs = jobInvitationVOs;
	}

	public JobInvitationService getJobInvitationService() {
		return jobInvitationService;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Resource
	public void setJobInvitationService(JobInvitationService jobInvitationService) {
		this.jobInvitationService = jobInvitationService;
	}
	
	
	
	

}
