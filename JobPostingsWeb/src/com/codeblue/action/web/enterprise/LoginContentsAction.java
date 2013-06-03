package com.codeblue.action.web.enterprise;

import javax.annotation.Resource;

import com.codeblue.model.property.EnterpriseAccountState;
import com.codeblue.service.enterprise.EmployeementInfoService;
import com.codeblue.service.enterprise.EnterpriseService;
import com.codeblue.service.enterprise.StudentService;
import com.codeblue.util.PageBean;

public class LoginContentsAction extends BaseAction {
	private int pageSize=10;
	private int pageNum=1;
	
	private PageBean pageBeanOne;
	private PageBean pageBeanTwo;
	private PageBean pageBeanThree;
	
	@Resource(name="ent_employeementInfoService")
	private EmployeementInfoService employeementInfoService;
	@Resource(name="ent_enterpriseService")
	private EnterpriseService enterpriseService;
	@Resource(name="ent_studentService")
	private StudentService studentService;
	
	
	public String loadContentOne(){
		pageBeanOne=employeementInfoService.getEmployeementInfos(pageNum, pageSize);
		return "success";
	}
	public String loadContentTwo(){
		Integer[] states={EnterpriseAccountState.PASS};
		pageBeanTwo=enterpriseService.queryEnterprises(states, pageNum, pageSize);
		return "success";
	}
	public String loadContentThree(){
		//int industryId=(int)(Math.random()*26)+1;
		int industryId=1;
		pageBeanThree=studentService.queryRecommandStudentsByJobIntention(industryId, pageNum, pageSize);
		return "success";
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public PageBean getPageBeanOne() {
		return pageBeanOne;
	}

	public void setPageBeanOne(PageBean pageBeanOne) {
		this.pageBeanOne = pageBeanOne;
	}
	public PageBean getPageBeanTwo() {
		return pageBeanTwo;
	}
	public void setPageBeanTwo(PageBean pageBeanTwo) {
		this.pageBeanTwo = pageBeanTwo;
	}
	public PageBean getPageBeanThree() {
		return pageBeanThree;
	}
	public void setPageBeanThree(PageBean pageBeanThree) {
		this.pageBeanThree = pageBeanThree;
	}

}
