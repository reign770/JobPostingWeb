package com.codeblue.service.enterprise;

import com.codeblue.util.PageBean;

public interface EvaluationService {
	
	public PageBean queryEvaluationsOfCompany(int enterpriseId,int pageNum,int pageSize);

}
