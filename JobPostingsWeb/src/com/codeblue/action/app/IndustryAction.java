package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.model.Industry;
import com.codeblue.service.student.RecruitmentService;
import com.codeblue.vo.RecruitmentItemVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("app_IndustryAction")
public class IndustryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6187460661613248572L;
		
	//返回参数
	private List<Industry> industries;
	
	//注入服务
	private RecruitmentService recruitmentService;

	public String showAllIndustries(){
		industries = recruitmentService.getAllIndustries();
		return "items";
	}
	
	public List<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}
	@Resource
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	
}
