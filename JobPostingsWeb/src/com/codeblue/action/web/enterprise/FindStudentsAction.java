package com.codeblue.action.web.enterprise;

import javax.annotation.Resource;

import com.codeblue.service.enterprise.StudentService;
import com.codeblue.util.PageBean;


public class FindStudentsAction extends BaseAction {
	private int pageSize=10;
	private int pageNum=1;
	private int classId;
	
	
	private PageBean pageBean;
	
	@Resource(name="ent_studentService")
	private StudentService studentService;
	
	public String load() {
		pageBean=studentService.queryStudentsOfAClass(classId, pageNum, pageSize);
		return "success";
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	

}
