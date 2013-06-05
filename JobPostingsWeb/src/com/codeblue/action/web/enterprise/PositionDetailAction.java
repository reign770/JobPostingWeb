package com.codeblue.action.web.enterprise;



import javax.annotation.Resource;

import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.codeblue.service.student.RecruitmentService;


public class PositionDetailAction extends BaseAction {
	
	private Recruitment recruitment;
	private int recruitmentId;
	private Boolean isApply;
	private RecruitmentService recruitmentService;
	public String load() {
		recruitment=recruitmentService.getRecruitment(recruitmentId);
		if(session.get("student") != null){
			String studentId = ((Student)session.get("student")).getStudentId();
			System.err.println("studentId:"+studentId);
			isApply = recruitmentService.isApplyRecruitment(studentId, recruitmentId);
			System.err.println("isApply:"+isApply);
		}
		return "success";
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public int getRecruitmentId() {
		return recruitmentId;
	}

	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public Boolean getApply() {
		return isApply;
	}

	public void setApply(Boolean isApply) {
		this.isApply = isApply;
	}

	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}
	@Resource
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	

	

	

}
