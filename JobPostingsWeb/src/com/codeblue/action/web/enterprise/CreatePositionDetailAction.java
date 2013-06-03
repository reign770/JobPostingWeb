package com.codeblue.action.web.enterprise;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.JobInvitationService;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.service.enterprise.StudentService;
import com.codeblue.util.PageBean;

public class CreatePositionDetailAction extends BaseAction {
	private int pageSize=10;
	private int pageNum=1;
	private int industryId;
	
	private PageBean pageBean=new PageBean();
	
	private Recruitment recruitment;
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	@Resource(name="ent_studentService")
	private StudentService studentService;
	@Resource(name="ent_jobInvitationService")
	private JobInvitationService jobInvitationService;
	
	private Map<String,Object> jsonMap=new HashMap<>();
	
	public String load() {
		return "success";
	}
	public String insert() {
		int recruitmentId;
		Enterprise enterprise=(Enterprise)session.get("user");
		recruitment.setEnterprise(enterprise);
		System.out.println(recruitment.getIndustry().getIndustryId()+" "+recruitment.getDeadline());
		recruitment.setState(RecruitmentState.POSTING);
		recruitment.setReleaseDate(new Date());
		recruitmentId=recruitmentService.insertRecruitment(recruitment);
		jsonMap.clear();
		jsonMap.put("msg", "success");
		jsonMap.put("recruitmentId", recruitmentId);
		return "success";
	}
	
	public String loadRecommendation(){
		//int industryId=(int)(Math.random()*26)+1;
		//industryId=1;
		pageBean=studentService.queryRecommandStudentsByJobIntention(industryId, pageNum, pageSize);
		return "success";
	}
	
	public String doInvitation(){
		
		 String s=request.getParameter("chooseIds");
		 int recruitmentId=Integer.parseInt(request.getParameter("recruitmentId"));
		 String[] studentIds=s.split(":");//被选中的列（要更改状态的列）
		 jobInvitationService.addJobInvitation(studentIds, recruitmentId);
		 jsonMap.put("msg", "success");
		return "success";
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
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
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


}
