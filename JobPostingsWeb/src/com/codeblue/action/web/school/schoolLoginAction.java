package com.codeblue.action.web.school;

import java.util.Map;

import javax.annotation.Resource;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.codeblue.service.admin.AdministratorService;
import com.opensymphony.xwork2.ActionSupport;


@Controller
public class schoolLoginAction extends ActionSupport implements SessionAware{

	private AdministratorService administratorService;
	private Map<String, Object> session;
	private String result;
	private String username;
	private String password;
	
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdministratorService getAdministratorService() {
		return administratorService;
	}
	@Resource
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	public String login() throws Exception{
		
//		String loginAccount=null;
//		String loginPasswd=null;
//		String result=null;
//		HttpServletRequest request=ServletActionContext.getRequest();
//		loginAccount=request.getParameter("username");
//		loginPasswd=request.getParameter("password");
		
		this.result=checkResult(this.username, this.password);
		
		return SUCCESS;
	}
	
	public String checkResult(String loginAccount,String loginPasswd){
		if(isEmpty(loginAccount, loginPasswd)){
			return "noaccount";
		}else{
			if(administratorService.isValidAdmin(loginAccount, loginPasswd)){
				session.put("adminAccount",loginAccount );
				return "login_success";
			}else{
				return "noaccount";
			}
		}
	}
	
	public boolean isEmpty(String loginAccount,String loginPasswd){
		
		if(loginAccount==null||loginAccount==""||loginPasswd==null||loginPasswd==""){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
