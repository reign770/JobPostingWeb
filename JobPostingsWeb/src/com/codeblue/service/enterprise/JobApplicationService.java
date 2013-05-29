package com.codeblue.service.enterprise;

import com.codeblue.model.JobApplication;
import com.codeblue.util.PageBean;

public interface JobApplicationService {
	
	//public PageBean querySeniorEmployees(int enterpriseId);
	
	public PageBean queryJobApplications(int recruitmentId, Integer[] state ,int pageNum,int pageSize);
	
	public JobApplication queryApplication(Long applyId);
	
	public void updateStudentState(JobApplication jobApplication,int state);



}
