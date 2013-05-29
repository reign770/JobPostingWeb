package com.codeblue.action.web.enterprise;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.RecruitmentService;

public class CreatePositionDetailAction extends BaseAction {
	private Recruitment recruitment;
	@Resource(name="ent_recruitmentService")
	private RecruitmentService recruitmentService;
	
	private Map<String,Object> jsonMap=new HashMap<>();
	
	public String load() {
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


}
