package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.enterprise.EvaluationService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.EvaluationVO;
import com.codeblue.vo.Status;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class EvaluationAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2074794739248914961L;
	public static int pageSize = 10;
	//传递参数
	private int enterpriseId;
	private int pageParam;
	private String studentId;//学生学号
	private String content;//发表内容
	//返回数据
	private List<EvaluationVO> evaluationVOs;
	private Status status;
	//注入服务
	private EvaluationService evaluationService;
	
	public String showEvaluations() {
		evaluationVOs = VOUntil.convertToEvaluationVOs(evaluationService
				.queryEvaluationsOfCompany(enterpriseId, pageParam, pageSize)
				.getList());
		return "items";
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public int getPageParam() {
		return pageParam;
	}
	public void setPageParam(int pageParam) {
		this.pageParam = pageParam;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<EvaluationVO> getEvaluationVOs() {
		return evaluationVOs;
	}
	public void setEvaluationVOs(List<EvaluationVO> evaluationVOs) {
		this.evaluationVOs = evaluationVOs;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public EvaluationService getEvaluationService() {
		return evaluationService;
	}
	@Resource
	public void setEvaluationService(EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
	}

}
