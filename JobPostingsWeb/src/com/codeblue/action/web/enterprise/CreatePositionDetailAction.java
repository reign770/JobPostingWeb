package com.codeblue.action.web.enterprise;

import java.util.Date;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.RecruitmentService;

public class CreatePositionDetailAction extends BaseAction {
	private Recruitment recruitment;
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	public String load() {
		return "success";
	}
	public String insert() {
		Enterprise enterprise=(Enterprise)session.get("user");
		recruitment.setEnterprise(enterprise);
		System.out.println(recruitment.getIndustry().getIndustryId()+" "+recruitment.getDeadline());
		recruitment.setState(RecruitmentState.POSTING);
		recruitment.setReleaseDate(new Date());
		recruitmentService.insertRecruitment(recruitment);
		return "success";
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}


}
