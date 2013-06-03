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
	
	private PageBean pageBean=new PageBean();
	
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	
	
	public String load() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		Integer[] states={RecruitmentState.POSTING};
		pageBean=recruitmentService.queryRecruitmentsOfCompany(enterpriseId,states , pageNum, pageSize);
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


	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
