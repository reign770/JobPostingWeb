package com.codeblue.service.student;

import org.hamcrest.core.Is;

import com.codeblue.util.EnterpriseAddition;
import com.codeblue.util.PageBean;

public interface EnterpriseService {
	
	public PageBean getConcernEnterprise(String studentId,int pageNumber,int pageSize);
	
	public void concernEnterprise(String studentId,int enterpriseId);
	
	public Boolean isConcernEnterprise(String studentId,int enterpriseId);
	
	public void unconcernEnterprise(String studentId,int enterpriseId);
	
	public PageBean queryEnterprise(EnterpriseAddition enterpriseAddition,int pageNumber,int pageSize);
	
	public void commentEnterpise(String studentId,int enterpriseId,String comment);
	
}
