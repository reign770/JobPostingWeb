package com.codeblue.action.web.enterprise;



import javax.annotation.Resource;

import com.codeblue.model.Recruitment;
import com.codeblue.service.enterprise.RecruitmentService;


public class PositionDetailAction extends BaseAction {
	
	private Recruitment recruitment;
	private int recruitmentId;
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	public String load() {
		recruitment=recruitmentService.queryRecruitment(recruitmentId);
		return "success";
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public int getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	

	

	

}
