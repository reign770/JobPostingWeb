package com.codeblue.action.web.school;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.codeblue.service.impl.admin.AdministratorServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class schoolModifyPasswdAction extends ActionSupport {

	public void changePasswd() throws IOException{
		
		String oldPasswd=null;
		String newPasswd=null;
		String newAaginPasswd=null;
		String result=null;
		HttpServletRequest request=ServletActionContext.getRequest();
		oldPasswd=request.getParameter("oldPasswd");
		newPasswd=request.getParameter("newPasswd");
		newAaginPasswd=request.getParameter("newAgainPasswd");
		if(isEqualNewPasswd(newPasswd, newAaginPasswd)){
			AdministratorServiceImpl adminServiceImp=new AdministratorServiceImpl();
			Map session=ActionContext.getContext().getSession();
			String adminAccount=(String)session.get("adminAccount");
			if(adminServiceImp.isValidAdmin(adminAccount,oldPasswd)){
				if(adminServiceImp.modifyPasswd(adminAccount, newPasswd)){
					result="successed";
				}else{
					result="failed";
				}
			}else{
				result="failed";
			}
		}else{
			result="failed";
		}
	}
	
	public boolean isEqualNewPasswd(String oldPasswd,String oldAgainPasswd){
		if(oldAgainPasswd==oldPasswd){
			return true;
		}else{
			return false;
		}
	}
}
