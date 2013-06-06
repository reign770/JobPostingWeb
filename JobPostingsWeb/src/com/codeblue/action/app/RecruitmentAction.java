package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.student.RecruitmentService;
import com.codeblue.util.QueryAddition;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.RecruitmentItemVO;
import com.codeblue.vo.RecruitmentVO;
import com.opensymphony.xwork2.ActionSupport;
@Controller("app_recruitmentAction")
public class RecruitmentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7340549388830579343L;
	public static final int pageSize = 10;
	//参数
	private String studentId;
	private int pageParam;
	private int recruitmentId;
	private int enterpriseId;
	private int industryId;
	private String enterpriseProperty;
	private String address;
	private int salary;
	private String keyword;
	//
	private List<RecruitmentItemVO> recruitmentItemVOs;
	private RecruitmentVO recruitmentVO;
	
	private RecruitmentService recruitmentService;
	//查看公司的所有的招聘信息
	public String showEnterpriseRecruitments(){
		
		recruitmentItemVOs = VOUntil.convertToRecruitmentItemVOs(
				recruitmentService.getEnterpriseRecruitments(enterpriseId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String searchRecruitments() {
		QueryAddition queryAddition = new QueryAddition();
		queryAddition.setIndustryId(industryId);
		
		queryAddition.setSalary(salary);
		if(enterpriseProperty != null)
		queryAddition.setEnterpriseProperty(enterpriseProperty);
		if(keyword != null)
		queryAddition.setQueryWord(keyword);
		if(address != null)
		queryAddition.setWorkingPlace(address);
		System.err.println("workingPlace:"+address);
		queryAddition.init();
		recruitmentItemVOs = VOUntil.convertToRecruitmentItemVOs(
				recruitmentService.queryRecruitment(queryAddition, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String showNewRecruitments() {
		QueryAddition queryAddition = new QueryAddition();
		recruitmentItemVOs = VOUntil.convertToRecruitmentItemVOs(
				recruitmentService.queryRecruitment(queryAddition, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String showConcernedEntRecruitments() {
		recruitmentItemVOs = VOUntil.convertToRecruitmentItemVOs(
				recruitmentService.getConcernRecruitments(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String showConcernedIndRecruitments() {
		recruitmentItemVOs = VOUntil.convertToRecruitmentItemVOs(
				recruitmentService.getJobIntentionRecruitments(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String showRecruitmentInfo(){
		recruitmentVO = VOUntil.convertToRecruitmentVO(
				recruitmentService.getRecruitment(recruitmentId));
		return "recruitment";
	}
	
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getPageParam() {
		return pageParam;
	}
	public void setPageParam(int pageParam) {
		this.pageParam = pageParam;
	}
	public long getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getEnterpriseProperty() {
		return enterpriseProperty;
	}
	public void setEnterpriseProperty(String enterpriseProperty) {
		this.enterpriseProperty = enterpriseProperty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public List<RecruitmentItemVO> getRecruitmentItemVOs() {
		return recruitmentItemVOs;
	}

	public void setRecruitmentItemVOs(List<RecruitmentItemVO> recruitmentItemVOs) {
		this.recruitmentItemVOs = recruitmentItemVOs;
	}

	public RecruitmentVO getRecruitmentVO() {
		return recruitmentVO;
	}

	public void setRecruitmentVO(RecruitmentVO recruitmentVO) {
		this.recruitmentVO = recruitmentVO;
	}

	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}
	@Resource
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	

}
