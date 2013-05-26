package com.codeblue.action.web.enterprise;

import java.util.Map;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.Login;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{
	@Resource(name="ent_login")
	private Login login;
	
	private Enterprise enterprise;
	
	public String execute() {
		if(enterprise==null){
			return "login";
		}
		login.login(enterprise);
		if("登录成功".equals(login.getMsg())){
			session.put("user", enterprise);
			return "success";
		}else{
			return "login";
		}
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	

	
}
