package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.model.Evaluation;
import com.codeblue.model.JobApplication;
import com.codeblue.service.enterprise.JobApplicationService;
import com.codeblue.util.PageBean;
@Service("ent_jobApplicationService")
public class JobApplicationServiceImpl implements JobApplicationService {
	@Resource(name="jobApplicationDAO")
	private JobApplicationDAO jobApplicationDAO;

	@Override
	public PageBean queryJobApplications(int recruitmentId,Integer[] states, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		List<JobApplication> list= jobApplicationDAO.queryByRecruitmentId(recruitmentId, states, (pageNum-1)*pageSize,pageSize);
		long allRow = jobApplicationDAO.getCountByRecruitmentId(recruitmentId, states);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

	@Override
	public void updateStudentState(JobApplication jobApplication,int state) {
		// TODO Auto-generated method stub
		jobApplication.setState(state);
		jobApplicationDAO.update(jobApplication);
	}

}
