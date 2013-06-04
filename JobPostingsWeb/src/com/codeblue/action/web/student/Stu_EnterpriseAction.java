package com.codeblue.action.web.student;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Student;
import com.codeblue.service.student.EnterpriseService;
import com.codeblue.util.EnterpriseAddition;
import com.codeblue.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

@Controller("stu_EnterpriseAction")
public class Stu_EnterpriseAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6525639290415889755L;
	private int enterpriseId;//企业编号
	private Map<String, Object> session;
	private PageBean pageBean;
	private EnterpriseAddition addition;
	private EnterpriseService enterpriseService;
	private int pageNumber;
	private int pageSize;
	public static final String ITEM = "item";
	private String message;
	//学生关注企业的主页
	public String concernEnterpriseHome(){
		String studentId = getStudentIdBySession();
		pageBean = enterpriseService.getConcernEnterprise(studentId, pageNumber, pageSize);
		return "concern";
	}
	//查询企业页面
	public String findEnterpriseHome(){
		addition = new EnterpriseAddition();
		initAddition();
		pageBean = enterpriseService.queryEnterprise(addition, pageNumber, pageSize);
		return "find";
	}
	//获取查询信息
	@JSON(serialize=false)
	public String getSearchResult(){
		initAddition();
		System.err.println("additon:"+addition.getQueryWord());
		pageBean = enterpriseService.queryEnterprise(addition, pageNumber, pageSize);
		return ITEM;
	}
	//获取关注企业
	@JSON(serialize=false)
	public String getConcernResult(){
		String studentId = getStudentIdBySession();
		pageBean = enterpriseService.getConcernEnterprise(studentId, pageNumber, pageSize);
		return "c_item";		
	}
	//关注企业
	public String concern(){
		enterpriseService.concernEnterprise(
				getStudentIdBySession(), enterpriseId);
		message = "concern_success";
		return "json_result";
	}
	//取消关注企业
	public String unconcern() {
		enterpriseService.unconcernEnterprise(
				getStudentIdBySession(), enterpriseId);
		System.err.println("uncocern");
		message = "unconcern_success";
		return "json_result";
	}
	//初始化条件
	private void initAddition(){
		if(addition != null)
			addition.init();
		else
		   addition = new EnterpriseAddition();
	}
	//从session中获取学生的Id
	private String getStudentIdBySession(){
		return ((Student)session.get("student")).getStudentId();
	}
	
	@JSON(serialize=false)
	public EnterpriseAddition getAddition() {
		return addition;
	}

	public void setAddition(EnterpriseAddition addition) {
		this.addition = addition;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@JSON(serialize=false)
	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}
	@Resource
	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	@JSON(serialize=false)
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	@JSON(serialize=false)
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	@JSON(serialize=false)
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@JSON(serialize=false)
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	@JSON(serialize=true)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
