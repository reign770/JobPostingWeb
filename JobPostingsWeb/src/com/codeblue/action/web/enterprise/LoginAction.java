package com.codeblue.action.web.enterprise;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.Login;

public class LoginAction extends BaseAction{
	@Resource(name="ent_login")
	private Login login;
	
	private Map<String,Object> jsonMap=new HashMap<>();
	
	private Enterprise enterprise;
	
	public String execute() {
		if(enterprise==null){
			return "login";
		}
		login.login(enterprise);
		int msg=login.getMsg();
		if(msg==1){
			session.put("user", enterprise);
			return "success";
		}else{
			return "login";
		}
	}
	
	public String login() {
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		enterprise=new Enterprise();
		enterprise.setEnterpriseAccount(account);
		enterprise.setPassword(password);
		login.login(enterprise);
		int msg=login.getMsg();
		if(msg==1){
			session.put("user", enterprise);
			jsonMap.put("loginmessage","login_success");
		}else if(msg==2){
			jsonMap.put("loginmessage","noaccount");
		}else if(msg==3){
			jsonMap.put("loginmessage","wrongpassword");
		}else{
			jsonMap.put("loginmessage","disable");
		}
		return "success";
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Map<String,Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String,Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	

	
}
