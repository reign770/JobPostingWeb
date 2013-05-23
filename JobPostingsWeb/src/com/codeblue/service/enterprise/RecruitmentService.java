package com.codeblue.service.enterprise;

import com.codeblue.model.Recruitment;
import com.codeblue.util.PageBean;

public interface RecruitmentService {
	
	public PageBean queryRecruitmentsOfCompany(int enterpriseId,int pageNum,int pageSize);
	
	public void insertRecruitment(Recruitment recruitment);
	
	public void updateRecruitment(Recruitment recruitment);

}
