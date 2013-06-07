package com.codeblue.action.web.school;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import com.codeblue.service.admin.AdministratorService;
import com.opensymphony.xwork2.ActionSupport;


@Controller
public class PostNewsAction extends ActionSupport implements SessionAware{

	private AdministratorService administratorService;
	
	
	private String title;
	private String news;
	private String result;
	private Map<String, Object> session;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public AdministratorService getAdministratorService() {
		return administratorService;
	}

	@Resource
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	public String postNews(){
		
		String account=(String)session.get("adminAccount");
		administratorService.postNews(news, title, account);
		this.setResult("successed");
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
	
}
