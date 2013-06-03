package com.codeblue.action.web.student;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Industry;
import com.codeblue.model.Student;
import com.codeblue.service.student.RecruitmentService;
import com.codeblue.util.PageBean;
import com.codeblue.util.QueryAddition;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class RecruitmentAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	public static final String ITEM = "item";
	private static final long serialVersionUID = 2422938403420221475L;
	private Map<String, Object> session;
	private int pageNumber;
	private int pageSize;
	private PageBean pageBean;
	private RecruitmentService recruitmentService;
	private QueryAddition addition;
	private List<Industry> industries;
	@Override
	public String execute() throws Exception {
		industries = recruitmentService.getAllIndustries();
		pageBean = new PageBean();
		pageBean.setAllRow(0);
		pageBean.setPageSize(10);
		pageBean.setCurrentPage(0);
		pageBean.init();
		return "find";
	}
	public String concern() {
		String studentId = ((Student)session.get("student")).getStudentId();
		pageBean = recruitmentService.getJobIntentionRecruitments(
				studentId, pageNumber, pageSize);
		return "concern";
	}
	//获取搜索的招聘信息
	public String getSearchResult(){
		if(addition != null)
			addition.init();
		System.err.println("property"+addition.getEnterpriseProperty());
		pageBean = recruitmentService
				.queryRecruitment(addition, pageNumber, pageSize);
		return ITEM;
	}
	//获取学生关注领域的招聘信息
	public String concernIndustry() {
		String studentId = ((Student)session.get("student")).getStudentId();
		pageBean = recruitmentService.getJobIntentionRecruitments(
				studentId, pageNumber, pageSize);
		return ITEM;
	}
	//获取学生关注企业的招聘信息
	public String concernEnterprise() {
		String studentId = ((Student)session.get("student")).getStudentId();
		pageBean = recruitmentService.getConcernRecruitments(
				studentId, pageNumber, pageSize);
		return ITEM;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public QueryAddition getAddition() {
		return addition;
	}


	public void setAddition(QueryAddition addition) {
		this.addition = addition;
	}

	
	public List<Industry> getIndustries() {
		return industries;
	}


	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}


	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}

	@Resource
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	
	
	

}
