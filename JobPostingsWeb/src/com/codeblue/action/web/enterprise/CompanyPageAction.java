package com.codeblue.action.web.enterprise;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.EnterpriseService;
import com.codeblue.service.enterprise.EvaluationService;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.service.impl.enterprise.EvaluationServiceImpl;
import com.codeblue.util.PageBean;

public class CompanyPageAction extends BaseAction {
	private int pageSize=1;
	private int pageNum=1;
	
	private Enterprise enterprise;
	private PageBean pageBean1;
	private PageBean pageBean2;
	private List<Recruitment> recruitments;
	private List<Evaluation> evaluations;

	@Resource(name="ent_enterpriseService")
	private EnterpriseService enterpriseService;
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	@Resource(name="ent_evaluationService")
	private EvaluationService evaluationService;
	
	public String load() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		Integer[] states={RecruitmentState.POSTING};
		enterprise=enterpriseService.queryEnterprise(enterpriseId);
		pageBean1=recruitmentService.queryRecruitmentsOfCompany(enterpriseId,states , pageNum, pageSize);
		recruitments=pageBean1.getList();
		pageBean2=evaluationService.queryEvaluationsOfCompany(enterpriseId,pageNum, pageSize);
		evaluations=pageBean2.getList();
		return "success";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public PageBean getPageBean1() {
		return pageBean1;
	}

	public void setPageBean1(PageBean pageBean1) {
		this.pageBean1 = pageBean1;
	}

	public PageBean getPageBean2() {
		return pageBean2;
	}

	public void setPageBean2(PageBean pageBean2) {
		this.pageBean2 = pageBean2;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	

}
