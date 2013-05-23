package com.codeblue.action.web.enterprise;

import javax.annotation.Resource;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.EnterpriseService;

public class CompanyPageAction extends BaseAction {
	private Enterprise enterprise;
	@Resource(name="ent_enterpriseService")
	private EnterpriseService enterpriseService;
	
	public String load() {
		enterprise=enterpriseService.queryEnterprise(((Enterprise)session.get("user")).getEnterpriseId());
		return "success";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	

}
