package com.codeblue.service.student;

import com.codeblue.util.PageBean;

public interface JobApplicationService {
	
	public PageBean getAllJobApplication(String studentId,int pageNumber,int pageSize);
	
	public int applyPosting(String studentId, int recruitmentId,String content);
}
