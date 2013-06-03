package com.codeblue.action.web.enterprise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.EnterpriseService;
import com.codeblue.service.enterprise.EvaluationService;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.util.PageBean;
import com.sun.net.httpserver.Authenticator.Success;

public class ArrangePositionsAction extends BaseAction {
	private int pageSize=10;
	private int pageNum=1;
	
	private PageBean pageBean;
	private List<Recruitment> recruitments;
	
	private Map<String,Object> jsonMap=new HashMap<>();

	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	
	public String load() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		Integer[] states={RecruitmentState.POSTING};
		pageBean=recruitmentService.queryRecruitmentsOfCompany(enterpriseId,states , pageNum, pageSize);
		recruitments=pageBean.getList();
		return "success";
	}
	
	public String stopRecruiting(){
		int recruitmentId=Integer.parseInt(request.getParameter("recruitmentId"));
		Recruitment recruitment=recruitmentService.queryRecruitment(recruitmentId);
		recruitment.setState(RecruitmentState.EXPIRED);
		recruitmentService.updateRecruitment(recruitment);
		jsonMap.clear();
		jsonMap.put("msg", "success");
		return "success";
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean1) {
		this.pageBean = pageBean;
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

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
}
