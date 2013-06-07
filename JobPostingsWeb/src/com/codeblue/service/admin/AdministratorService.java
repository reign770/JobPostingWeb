package com.codeblue.service.admin;

import java.util.Map;

import com.codeblue.model.Administrator;
import com.codeblue.util.PageBean;

/**
 * 
 * @author 
 * @datetime 2013-5-20 下午10:41:23
 */
public interface AdministratorService {
	public boolean isValidAdmin(String loginAdminAccount,String loginAdminPasswd);
	
	public boolean modifyPasswd(String loginAdminAccount,String newPasswd);
	
	public PageBean querySingUpEnterprise(Integer[] states,int page,int rows);
	
	public Map<String,Object> convertEnterpriseInfoToMap(PageBean pagebean);
	
	public PageBean queryAllStudent(Integer[] states,int page,int rows);
	
	public Map<String, Object> convertStudentInfoToMap(PageBean pagebean);
	
	public boolean postNews(String news,String title,String account);
	
	public boolean verifyEnterprisePass(String enterpriseId);
	
	public boolean verifyEnterpriseUnPass(String enterpriseId);
}
