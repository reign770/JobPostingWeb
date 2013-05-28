package com.codeblue.service.impl.student;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.dao.JobInvitationDAO;
import com.codeblue.model.JobApplication;
import com.codeblue.model.JobInvitation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.JobApplicationState;
import com.codeblue.model.property.JobInvitationState;
import com.codeblue.service.student.JobInvitationService;
import com.codeblue.util.PageBean;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
@Service("jobInvitationService")
public class JobInvitationServiceImpl implements JobInvitationService {
	
	private JobInvitationDAO jobInvitationDAO;
	private JobApplicationDAO jobApplicationDAO;
	
	@Override
	public PageBean getIngoredJobInvitations(String studentId, int pageNumber,
			int pageSize) {
		List<JobInvitation> list = jobInvitationDAO.queryByStudentId(studentId, 
								  new Integer[]{JobInvitationState.INGORE}, (pageNumber-1)*pageSize, pageSize);
		long allRow = jobInvitationDAO.getCountByStudentId(studentId, 
								  new Integer[]{JobInvitationState.INGORE});
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setList(list);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();
		return pageBean;
	}

	@Override
	public PageBean getAcceptedJobInvitations(String studentId, int pageNumber,
			int pageSize) {
		List<JobInvitation> list = jobInvitationDAO.queryByStudentId(studentId, 
				  new Integer[]{JobInvitationState.ACCEPT}, (pageNumber-1)*pageSize, pageSize);
		long allRow = jobInvitationDAO.getCountByStudentId(studentId, 
						  new Integer[]{JobInvitationState.ACCEPT});
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setList(list);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();		
		return pageBean;
	}

	@Override
	public PageBean getAllJobInvitations(String studentId, int pageNumber,
			int pageSize) {
		List<JobInvitation> list = jobInvitationDAO.queryByStudentId(studentId, 
				  JobInvitationState.ALL, (pageNumber-1)*pageSize, pageSize);
		long allRow = jobInvitationDAO.getCountByStudentId(studentId, 
				JobInvitationState.ALL);
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setList(list);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();		
		return pageBean;		
	}
	
	
	@Override
	public PageBean getUnProcessInvitations(String studentId, int pageNumber,
			int pageSize) {
		List<JobInvitation> list = jobInvitationDAO.queryByStudentId(studentId, 
				  new Integer[]{JobInvitationState.UNPROCESS}, (pageNumber-1)*pageSize, pageSize);
		long allRow = jobInvitationDAO.getCountByStudentId(studentId, 
				new Integer[]{JobInvitationState.UNPROCESS});
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setList(list);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();		
		return pageBean;
	}

	@Override
	public int acceptJobInvitation(long invitationId,String content) {
		JobInvitation jobInvitation = jobInvitationDAO
				.getByInvitationId(invitationId);
		//判断是否已经申请该职位
		JobApplication j=jobApplicationDAO.getByJobApplicationFK(
				jobInvitation.getStudent().getStudentId(), 
				jobInvitation.getRecruitment().getRecruitmentId());
		System.err.println(j);
		if(j != null){
			jobInvitation.setState(JobInvitationState.INGORE);
			jobInvitationDAO.update(jobInvitation);
			return 0;
		}
		jobInvitation.setState(JobInvitationState.ACCEPT);
		jobInvitationDAO.update(jobInvitation);
		JobApplication jobApplication = new JobApplication();
		jobApplication.setStudent(jobInvitation.getStudent());
		jobApplication.setApplyDate(new Date());
		if(content==null||content.equals(""))
		jobApplication.setContent("我接受你们的邀请,应聘"+jobInvitation.getRecruitment().getDegree());
		else {
			jobApplication.setContent(content);
		}
		jobApplication.setRecruitment(jobInvitation.getRecruitment());
		jobApplication.setState(JobApplicationState.PROCESSING);
		jobApplicationDAO.insert(jobApplication);
		System.err.println(1);
		return 1;
	}

	@Override
	public int ingoreJobInvitation(long invitationId) {
		JobInvitation jobInvitation = jobInvitationDAO
				.getByInvitationId(invitationId);
		jobInvitation.setState(JobInvitationState.INGORE);
		jobInvitationDAO.update(jobInvitation);
		return 0;
	}

	public JobInvitationDAO getJobInvitationDAO() {
		return jobInvitationDAO;
	}
	@Resource
	public void setJobInvitationDAO(JobInvitationDAO jobInvitationDAO) {
		this.jobInvitationDAO = jobInvitationDAO;
	}

	public JobApplicationDAO getJobApplicationDAO() {
		return jobApplicationDAO;
	}
	@Resource
	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO) {
		this.jobApplicationDAO = jobApplicationDAO;
	}

	
}
