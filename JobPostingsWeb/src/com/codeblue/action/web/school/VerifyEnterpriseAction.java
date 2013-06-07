package com.codeblue.action.web.school;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.admin.AdministratorService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class VerifyEnterpriseAction extends ActionSupport {

	private AdministratorService administratorService;
	private String result;
	private String enterpriseId;

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getEnterpriseId() {
		return enterpriseId;
	}


	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}


	public AdministratorService getAdministratorService() {
		return administratorService;
	}

	
	@Resource
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}
	
	public String verifyEnterprisePass(){
		
		if(this.isEmptyId()){
			this.result="failed";
		}else if(!this.administratorService.verifyEnterprisePass(this.enterpriseId.trim())){
			this.result="failed";
		}else{
			this.result="successed";
		}
		
		return SUCCESS;
	}
	
	public String verifyEnterpriseUnPass(){
		if(this.isEmptyId()){
			this.result="failed";
		}else if(!this.administratorService.verifyEnterpriseUnPass(this.enterpriseId.trim())){
			this.result="failed";
		}else{
			this.result="successed";
		}
		
		return SUCCESS;
	}
	
	public boolean isEmptyId(){
		if(this.enterpriseId.equals("")){
			return true;
		}else{
			return false;
		}
	}
	
}
