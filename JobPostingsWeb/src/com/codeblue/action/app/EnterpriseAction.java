package com.codeblue.action.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.student.EnterpriseService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.EnterpriseItemVO;
import com.codeblue.vo.EnterpriseVO;
import com.codeblue.vo.Status;
import com.opensymphony.xwork2.ActionSupport;
@Controller("app_enterpriseAction")
public class EnterpriseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 42829919519706238L;
	
	private int enterpriseId;
	private String studentId;
	private String state;//是否关注 followed,cancel
	
	private EnterpriseVO enterpriseVO;
	private EnterpriseItemVO enterpriseItemVOs;
	private Status status;
	private EnterpriseService enterpriseService;
	
	public String showEnterpriseInfo() {
		
		enterpriseVO = VOUntil.convertToEnterpriseVO(enterpriseService.getEnterpriseById(enterpriseId)
				, enterpriseService.isConcernEnterprise(studentId, enterpriseId));
		
		return "enterprise";
	}

	public String concernOrNotEnterprise() {
		if(state.equalsIgnoreCase("followed")) {
			enterpriseService.concernEnterprise(studentId, enterpriseId);
		}
		else {
			enterpriseService.unconcernEnterprise(studentId, enterpriseId);
		}
		status.setStatus("succeed");
		return "result";
	}
	
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public EnterpriseVO getEnterpriseVO() {
		return enterpriseVO;
	}

	public void setEnterpriseVO(EnterpriseVO enterpriseVO) {
		this.enterpriseVO = enterpriseVO;
	}

	public EnterpriseItemVO getEnterpriseItemVOs() {
		return enterpriseItemVOs;
	}

	public void setEnterpriseItemVOs(EnterpriseItemVO enterpriseItemVOs) {
		this.enterpriseItemVOs = enterpriseItemVOs;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}
	@Resource
	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	
	
	
	
	
	

}
