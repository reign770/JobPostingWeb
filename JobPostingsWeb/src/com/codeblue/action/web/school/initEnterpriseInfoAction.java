package com.codeblue.action.web.school;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.model.property.EnterpriseAccountState;
import com.codeblue.service.admin.AdministratorService;
import com.codeblue.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class initEnterpriseInfoAction extends ActionSupport{

	private int rows;
	private int page=1;
	private AdministratorService administratorService;
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

	private PageBean pageBean;
	private Map<String, Object> jsonMap=new HashMap<>();
	
	
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
	

	public String initInfo(){
		Integer[] states={EnterpriseAccountState.AUDITING};
		pageBean=administratorService.querySingUpEnterprise(states, page, rows);
//		jsonMap.clear();
//		//提取所需字段
//		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
//		return "success";

		jsonMap.clear();
		jsonMap=administratorService.convertEnterpriseInfoToMap(pageBean);
		return "success";
	}

	public AdministratorService getAdministratorService() {
		return administratorService;
	}
	@Resource
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}
	
	
}
