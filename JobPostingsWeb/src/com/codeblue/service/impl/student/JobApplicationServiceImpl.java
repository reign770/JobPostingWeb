package com.codeblue.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.model.JobApplication;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.codeblue.model.property.JobApplicationState;
import com.codeblue.service.student.JobApplicationService;
import com.codeblue.util.PageBean;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{
	
	private JobApplicationDAO jobApplicationDAO;
	
	@Override
	public PageBean getAllJobApplication(String studentId, int pageNumber,
			int pageSize) {
		List<JobApplication> list = jobApplicationDAO.queryByStudentId(studentId, 
									JobApplicationState.ALL, 
									(pageNumber-1)*pageSize, 
									pageSize);
		long allRow = jobApplicationDAO.getCountByStudentId(studentId, 
				JobApplicationState.ALL);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNumber);
		pageBean.init();
		return pageBean;
	}

	@Override
	public int applyPosting(String studentId, int recruitmentId, String content) {
		JobApplication jobApplication = new JobApplication();
		Student student = new Student();
		student.setStudentId(studentId);
		Recruitment recruitment = new Recruitment();
		recruitment.setRecruitmentId(recruitmentId);
		jobApplication.setStudent(student);
		jobApplication.setContent(content);
		jobApplication.setRecruitment(recruitment);
		jobApplication.setState(JobApplicationState.UNPROCESS);
		jobApplicationDAO.insert(jobApplication);
		return 0;
	}

	public JobApplicationDAO getJobApplicationDAO() {
		return jobApplicationDAO;
	}
	@Resource
	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO) {
		this.jobApplicationDAO = jobApplicationDAO;
	}
	
	

	
}
