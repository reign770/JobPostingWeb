package com.codeblue.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.IndustryDAO;
import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.dao.RecruitmentDAO;
import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Industry;
import com.codeblue.model.JobApplication;
import com.codeblue.model.Recruitment;
import com.codeblue.service.student.RecruitmentService;
import com.codeblue.util.PageBean;
import com.codeblue.util.QueryAddition;
@Service
public class RecruitmentServiceImpl implements RecruitmentService{
	
	private RecruitmentDAO recruitmentDAO;
	private JobApplicationDAO jobApplicationDAO;
	private IndustryDAO industryDAO;
	private StudentDAO studentDAO;
	
	@Override
	public PageBean queryRecruitment(QueryAddition queryAddition,
			int pageNumber, int pageSize) {
		List<Recruitment> list =
		recruitmentDAO.queryByAddition(queryAddition.getQueryWord(), 
									   queryAddition.getPostingName(), 
									   queryAddition.getWorkingPlace(), 
									   queryAddition.getSalary(), 
									   queryAddition.getEnterpriseProperty(),
									   queryAddition.getIndustryId(),
									   (pageNumber-1)*pageSize,
									   pageSize);
		long allRow = recruitmentDAO.getCountByAddition(
				   queryAddition.getQueryWord(), 
				   queryAddition.getPostingName(), 
				   queryAddition.getWorkingPlace(), 
				   queryAddition.getSalary(), 
				   queryAddition.getEnterpriseProperty(),
				   queryAddition.getIndustryId());
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setAllRow(allRow);
		pageBean.init();
		return pageBean;
	}

	@Override
	public Recruitment getRecruitment(int recruitmentId) {
		return recruitmentDAO.getByRecruitmentId(recruitmentId);
	}

	@Override
	public PageBean getConcernRecruitments(String studentId, int pageNumber,
			int pageSize) {
		List<Recruitment> list = 
	    recruitmentDAO.queryByStudentId(studentId, 
	    		                        (pageNumber-1)*pageSize, 
	    		                        pageSize);
		long allRow = recruitmentDAO.getCountByStudentId(studentId);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setAllRow(allRow);
		pageBean.init();
		return pageBean;
	}

	@Override
	public PageBean getJobIntentionRecruitments(String studentId,
			int pageNumber, int pageSize) {
		int industryId = studentDAO
				         .getByStudentId(studentId)
				         .getJobIntention().getIndustryId();
		List<Recruitment> list =
	    recruitmentDAO.queryByIndustry(industryId, (pageNumber-1)*pageSize, pageSize);
		long allRow =
		recruitmentDAO.getCountByIndustry(industryId);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNumber);
		pageBean.init();
		return pageBean;
	}
	

	@Override
	public PageBean getEnterpriseRecruitments(int enterpriseId, int pageNumber,
			int pageSize) {
		List<Recruitment> list =
			    recruitmentDAO.queryByEnterpriseId(enterpriseId, new Integer[]{1},(pageNumber-1)*pageSize, pageSize);
				long allRow =
				recruitmentDAO.getCountByEnterpriseId(enterpriseId, new Integer[]{1});
				PageBean pageBean = new PageBean();
				pageBean.setList(list);
				pageBean.setAllRow(allRow);
				pageBean.setPageSize(pageSize);
				pageBean.setCurrentPage(pageNumber);
				pageBean.init();
		return pageBean;
	}
	
	@Override
	public Boolean isApplyRecruitment(String studentId, int recruitmentId) {
		//判断是否已经申请该职位
		JobApplication j=jobApplicationDAO.getByJobApplicationFK(
				studentId,recruitmentId);
		if(j != null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Industry> getAllIndustries() {
		return industryDAO.getAllIndustries();
	}

	public RecruitmentDAO getRecruitmentDAO() {
		return recruitmentDAO;
	}
	@Resource
	public void setRecruitmentDAO(RecruitmentDAO recruitmentDAO) {
		this.recruitmentDAO = recruitmentDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Resource
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public IndustryDAO getIndustryDAO() {
		return industryDAO;
	}
	@Resource
	public void setIndustryDAO(IndustryDAO industryDAO) {
		this.industryDAO = industryDAO;
	}

	public JobApplicationDAO getJobApplicationDAO() {
		return jobApplicationDAO;
	}
	@Resource
	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO) {
		this.jobApplicationDAO = jobApplicationDAO;
	}
	
	
	
	
}
