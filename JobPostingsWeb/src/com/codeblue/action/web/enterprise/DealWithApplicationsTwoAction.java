package com.codeblue.action.web.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.codeblue.model.JobApplication;
import com.codeblue.model.property.JobApplicationState;
import com.codeblue.service.enterprise.JobApplicationService;
import com.codeblue.service.enterprise.NotificationService;
import com.codeblue.service.enterprise.PageBeanToJsonMapService;
import com.codeblue.util.PageBean;

/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
public class DealWithApplicationsTwoAction{
	private int rows=10;//跟其他action不一样的原因是因为 为了适应datagrid的变量名
	private int page=1;
	
	private PageBean pageBean=new PageBean();
	private int recruitmentId;
	private Map<String,Object> jsonMap=new HashMap<>();
	
	
	
	@Resource(name="ent_jobApplicationService")
	private JobApplicationService jobApplicationService;
	@Resource(name="ent_PageBeanToJsonMapService")
	private PageBeanToJsonMapService pageBeanToJsonMapService;
	@Resource(name="ent_notificationService")
	private NotificationService notificationService;
	
	
	
	/**
	 * 只负责跳转
	 * @return
	 */
	public String redirect() {
		
		return "success";
	}
	/**
	 * 获取所有
	 * @return
	 */
	public String load() {
		
		Integer[] states=JobApplicationState.ALL;
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	/**
	 * 获取未处理的
	 * @return
	 */
	public String loadProcessing() {
		
		Integer[] states={JobApplicationState.PROCESSING};
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	/**
	 * 获取通过简历筛选的
	 * @return
	 */
	public String loadResumepass() {
		
		Integer[] states={JobApplicationState.RESUMEPASS};
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	/**
	 * 获取通过笔试的
	 * @return
	 */
	public String loadWritepass() {
		
		Integer[] states={JobApplicationState.WRITTEPASS};
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	/**
	 * 获取通过面试的
	 * @return
	 */
	public String loadInterviewpass() {
		
		Integer[] states={JobApplicationState.INTERVIEWPASS};
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	/**获取已签约的
	 * @return
	 */
	public String loadSigned() {
		
		Integer[] states={JobApplicationState.SIGNED};
		pageBean=jobApplicationService.queryJobApplications(recruitmentId, states,page,rows);
		jsonMap.clear();
		//提取所需字段
		jsonMap=pageBeanToJsonMapService.convertOfDWATA(pageBean);
		return "success";
	}
	
	
	
	/**
	 * 更新状态
	 * @return
	 */
	public String changeToResumepass(){
		changeState(JobApplicationState.RESUMEPASS);
		jsonMap.clear();
		jsonMap.put("msg","更新成功!");
		return "success";
	}
	public String changeToWritepass(){
		changeState(JobApplicationState.WRITTEPASS);
		jsonMap.clear();
		jsonMap.put("msg","更新成功!");
		return "success";
	}
	public String changeToInterviewpass(){
		changeState(JobApplicationState.INTERVIEWPASS);
		jsonMap.clear();
		jsonMap.put("msg","更新成功!");
		return "success";
	}
	public String changeToSigned(){
		changeState(JobApplicationState.SIGNED);
		jsonMap.clear();
		jsonMap.put("msg","更新成功!");
		return "success";
	}
	public String changeToRejected(){
		changeState(JobApplicationState.REJECTED);
		jsonMap.clear();
		jsonMap.put("msg","更新成功!");
		return "success";
	}
	
	
	/**
	 * 改变状态的公共函数 仅供内部调用
	 * @param state
	 */
	private void changeState(int state) {
		 HttpServletRequest request = ServletActionContext.getRequest(); 
		 String s=request.getParameter("selections");
		 String stuIds=request.getParameter("studentIds");
		 int entId=Integer.parseInt(request.getParameter("enterpriseId"));
		 String[] selections=s.split(":");//被选中的列（要更改状态的列）
		 String[] studentIds=stuIds.split(":");
		for (int i = 0; i < selections.length; i++) {
			
			Long applyId=Long.parseLong(selections[i]);
			JobApplication jobApplication=jobApplicationService.queryApplication(applyId);
			jobApplicationService.updateStudentState(jobApplication, state);
			notificationService.saveNotifications(entId, studentIds[i], state);
			
		}
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
	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public int getRecruitmentId() {
		return recruitmentId;
	}


	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	
	


	
	
}
