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
	private int pageSize=10;
	
	private Enterprise enterprise;
	private PageBean pageBean;
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
		pageBean=recruitmentService.queryRecruitmentsOfCompany(enterpriseId,states , 1, pageSize);
		recruitments=pageBean.getList();
		pageBean=evaluationService.queryEvaluationsOfCompany(enterpriseId, 1, pageSize);
		evaluations=pageBean.getList();
		return "success";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
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
	

}
