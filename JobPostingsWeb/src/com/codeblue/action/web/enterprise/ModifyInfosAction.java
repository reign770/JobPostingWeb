package com.codeblue.action.web.enterprise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import sun.net.www.content.audio.basic;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.RecruitmentState;
import com.codeblue.service.enterprise.EnterpriseService;
import com.codeblue.service.enterprise.EvaluationService;
import com.codeblue.service.enterprise.RecruitmentService;
import com.codeblue.util.PageBean;

public class ModifyInfosAction extends BaseAction {
	
	private Enterprise enterprise;

	@Resource(name="ent_enterpriseService")
	private EnterpriseService enterpriseService;
	
	private Map<String,Object> jsonMap=new HashMap<>();
	
	public String load() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		enterprise=enterpriseService.queryEnterprise(enterpriseId);
		return "success";
	}
	
	public String update() {
		int enterpriseId=((Enterprise)session.get("user")).getEnterpriseId();
		Enterprise enterprise2=enterpriseService.queryEnterprise(enterpriseId);
		enterprise2.setPassword(enterprise.getPassword());
		enterprise2.setEnterpriseName(enterprise.getEnterpriseName());
		enterprise2.setAddress(enterprise.getAddress());
		enterprise2.setLinkman(enterprise.getLinkman());
		enterprise2.setPhone(enterprise.getPhone());
		enterprise2.setFax(enterprise.getFax());
		enterprise2.setWebSite(enterprise.getWebSite());
		enterprise2.setEnterpriseLegalPerson(enterprise.getEnterpriseLegalPerson());
		enterprise2.setBusinessLicenseId(enterprise.getBusinessLicenseId());
		enterprise2.setBrief(enterprise.getBrief());
		enterpriseService.updateEnterprise(enterprise2);
		jsonMap.clear();
		jsonMap.put("msg", "success");
		return "success";
	}
	
	
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	

}
