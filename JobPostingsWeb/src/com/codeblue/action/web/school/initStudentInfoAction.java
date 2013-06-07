package com.codeblue.action.web.school;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.model.property.StudentAccount;
import com.codeblue.service.admin.AdministratorService;
import com.codeblue.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class initStudentInfoAction extends ActionSupport{

	private int rows;
	private int page;
	
	private AdministratorService administratorService;
	private PageBean pageBean;
	private Map<String, Object> jsonMap=new HashMap<String, Object>();
	
	public String initInfo(){
		
		//error
		Integer[] states=StudentAccount.ALL;
		pageBean=administratorService.queryAllStudent(states, page, rows);
		jsonMap.clear();
		//jsonMap=administratorService.convertStudentInfoToMap(pagebean);
		return "success";
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public AdministratorService getAdministratorService() {
		return administratorService;
	}
	@Resource
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
}
