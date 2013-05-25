package com.codeblue.action.web.enterprise;

import java.util.List;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.util.PageBean;

public class DealWithApplicationsOneAction extends BaseAction{
	private int pageSize=10;
	private int pageNum=1;
	
	private PageBean pageBean;
	private List<Recruitment> recruitments;
	
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	
	
	public String load() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		Integer[] states={RecruitmentState.POSTING};
		pageBean=recruitmentService.queryRecruitmentsOfCompany(enterpriseId,states , pageNum, pageSize);
		recruitments=pageBean.getList();
		return "success";
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public List<Recruitment> getRecruitments() {
		return recruitments;
	}


	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}
}
