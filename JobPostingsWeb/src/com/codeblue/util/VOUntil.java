package com.codeblue.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.JobApplication;
import com.codeblue.model.JobInvitation;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.codeblue.model.property.JobApplicationState;
import com.codeblue.vo.EnterpriseItemVO;
import com.codeblue.vo.EnterpriseVO;
import com.codeblue.vo.EvaluationVO;
import com.codeblue.vo.JobApplicationVO;
import com.codeblue.vo.JobInvitationVO;
import com.codeblue.vo.RecruitmentItemVO;
import com.codeblue.vo.RecruitmentVO;
import com.codeblue.vo.StudentVO;

public class VOUntil {
	private static SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formator_time =
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 转换成学生值对象
	 * @param student
	 * @return
	 */
	public static StudentVO convertToStudentVO(Student student){
		StudentVO studentVO = new StudentVO();
		studentVO.setStudentId(student.getStudentId());
		studentVO.setName(student.getName());
		studentVO.setSex(student.getSex());
		studentVO.setBirthday(formator.format(student.getBirthday()));
		studentVO.setNation(student.getNation());
		studentVO.setAddress(student.getAddress());
		studentVO.setEmail(student.getEmail());
		studentVO.setIdNum(student.getIdNum());
		studentVO.setTelephone(student.getTelephone());
		studentVO.setEmail(student.getEmail());
		studentVO.setHeadImage(student.getHeadImage());
		studentVO.setSchool(student.getSchool());
		studentVO.setDegree(student.getDegree());
		studentVO.setGpa(String.valueOf(student.getGpa()));
		studentVO.setGraduationDate(formator.format(
				student.getGraduationDate()));
		
		studentVO.setClassName(student.getSchoolClass().getClassName());
		studentVO.setMajorName(student.getSchoolClass().getMajor()
				.getMajorName());
		studentVO.setDepartmentName(student.getSchoolClass()
				.getMajor().getDepartment().getDepartmentName());
		
		studentVO.setInterests(student.getBrief().getInterests().split(","));
		studentVO.setMajorCourse(student.getBrief().getMajorCourse().split(","));
		studentVO.setHonor(student.getBrief().getHonor().split(","));
		studentVO.setExperience(student.getBrief().getExperience().split(","));
		studentVO.setResume(student.getBrief().getResume());
		return studentVO;
	}
	
	/**
	 * 转换成招聘信息值对象
	 * @param recruitment
	 * @return
	 */
	public static RecruitmentVO convertToRecruitmentVO(Recruitment recruitment) {
		RecruitmentVO recruitmentVO = new RecruitmentVO();
		recruitmentVO.setPostingName(recruitment.getPostingName());
		recruitmentVO.setRecruitmentCount(recruitment.getRecruitmentCount()+"人");
		recruitmentVO.setWorkingPlace(recruitment.getWorkingPlace());
		recruitmentVO.setReleaseDate(formator.format(recruitment.getReleaseDate()));
		recruitmentVO.setDeadline(formator.format(recruitment.getDeadline()));
		if(recruitment.getSalary() < 0)
		 recruitmentVO.setSalary("面议");
		else {
		 recruitmentVO.setSalary(recruitment.getSalary()+"元左右");
		}
		recruitmentVO.setSex(recruitment.getSex());
		recruitmentVO.setWorkExperience(recruitment.getWorkExperience());
		recruitmentVO.setAge(recruitment.getAge());
		recruitmentVO.setForeignLanguage(recruitment.getForeignLanguage());
		recruitmentVO.setDegree(recruitment.getDegree());
		recruitmentVO.setResponsibilities(recruitment.getResponsibilities());
		recruitmentVO.setQualification(recruitment.getQualification());
		recruitmentVO.setEnterpriseId(recruitment.getEnterprise().getEnterpriseId());
		recruitmentVO.setEnterpriseLogo(recruitment.getEnterprise().getLogo());
		return recruitmentVO;
	}
	/**
	 * 转换成企业值对象
	 * @param enterprise
	 * @param isConcerned
	 * @return
	 */
	public static EnterpriseVO convertToEnterpriseVO(Enterprise enterprise ,
			boolean isConcerned) {
		EnterpriseVO enterpriseVO = new EnterpriseVO();
		enterpriseVO.setEnterpriseId(String.valueOf(enterprise.getEnterpriseId()));
		enterpriseVO.setEnterpriseName(enterprise.getEnterpriseName());
		enterpriseVO.setEnterpriseScale(enterprise.getEnterpriseScale());
		enterpriseVO.setAddress(enterprise.getAddress());
		enterpriseVO.setRegisteredFund(enterprise.getRegisteredFund()+"万");
		enterpriseVO.setWebSite(enterprise.getWebSite());
		enterpriseVO.setBrief(enterprise.getBrief());
		enterpriseVO.setFoundDate(formator.format(enterprise.getFoundDate()));
		enterpriseVO.setEnterpriseLogo(enterprise.getLogo());
		if(isConcerned) {
			enterpriseVO.setFollowed("followed");
		}else {
			enterpriseVO.setFollowed("cancel");
		}
		return enterpriseVO;
	}
	
	/**
	 * 转换成招聘信息值对象列表
	 * @param recruitments
	 * @return
	 */
	public static List<RecruitmentItemVO> convertToRecruitmentItemVOs(List<Recruitment> recruitments) {
		List<RecruitmentItemVO> list = new ArrayList<>();
		for(Recruitment recruitment : recruitments){
			RecruitmentItemVO recruitmentItemVO = new RecruitmentItemVO();
			recruitmentItemVO.setEnterpriseId(String.valueOf(recruitment.getRecruitmentId()));
			recruitmentItemVO.setEnterpriseLogo(recruitment.getEnterprise().getLogo());
			recruitmentItemVO.setEnterpriseName(recruitment.getEnterprise().getEnterpriseName());
			recruitmentItemVO.setPostingName(recruitment.getPostingName());
			recruitmentItemVO.setRecruitmentId(String.valueOf(recruitment.getRecruitmentId()));
			recruitmentItemVO.setSalary(recruitment.getSalary()+"元左右");
			recruitmentItemVO.setWorkingPlace(recruitment.getWorkingPlace());
			list.add(recruitmentItemVO);
		}
		return list;
	}
	/**
	 * 转换成企业值对象列表
	 * @param enterprises
	 * @return
	 */
	public static List<EnterpriseItemVO> convertToEnterpriseItemVOs(List<Enterprise> enterprises) {
		List<EnterpriseItemVO> list = new ArrayList<>();
		for(Enterprise enterprise :enterprises){
			EnterpriseItemVO enterpriseItemVO = new EnterpriseItemVO();
			enterpriseItemVO.setEnterpriseId(enterprise.getEnterpriseId());
			enterpriseItemVO.setEnterpirseName(enterprise.getEnterpriseName());
			enterpriseItemVO.setEnterpriseLogo(enterprise.getLogo());
			list.add(enterpriseItemVO);
		}
		return list;
		
	}
	/**
	 * 转换成评论值对象列表
	 * @param evaluations
	 * @return
	 */
	public static List<EvaluationVO> convertToEvaluationVOs(List<Evaluation> evaluations) {
		List<EvaluationVO> list = new ArrayList<>();
		for(Evaluation evaluation : evaluations) {
			EvaluationVO evaluationVO = new EvaluationVO();
			evaluationVO.setEvaluationId(evaluation.getEvaluationId());
			evaluationVO.setInfo(evaluation.getContent());
			evaluationVO.setPubdate(formator_time.format(evaluation.getPubdate()));
			evaluationVO.setStudentName(evaluation.getStudent().getName());
			list.add(evaluationVO);
		}
		return list;
	}
	/**
	 * 转换成邀请值对象列表
	 * @param jobApplications
	 * @return
	 */
	public static List<JobApplicationVO> convertToJobApplicationVOs(List<JobApplication> jobApplications ) {
		List<JobApplicationVO> list = new ArrayList<>();
		for(JobApplication jobApplication : jobApplications) {
			JobApplicationVO jobApplicationVO = new JobApplicationVO();
			jobApplicationVO.setJobApplicationId(String.valueOf(jobApplication.getApplyId()));
			jobApplicationVO.setEnterpriseName(jobApplication.getRecruitment()
					.getEnterprise().getEnterpriseName());
			jobApplicationVO.setPostingName(jobApplication
					.getRecruitment().getPostingName());
			if(jobApplication.getState() == JobApplicationState.PROCESSING) {
				jobApplicationVO.setState("处理中");
			}else if(jobApplication.getState() == JobApplicationState.INTERVIEWPASS) {
				jobApplicationVO.setState("面试通过");
			}else if(jobApplication.getState() == JobApplicationState.REJECTED) {
				jobApplicationVO.setState("申请被拒绝");
			}else if(jobApplication.getState() == JobApplicationState.RESUMEPASS) {
				jobApplicationVO.setState("简历通过");
			}else if(jobApplication.getState() == JobApplicationState.SIGNED) {
				jobApplicationVO.setState("已签约");
			}else {
				jobApplicationVO.setState("笔试已通过");
			}
			list.add(jobApplicationVO);
		}
		return list;
	}
	/**
	 * 转换成邀请信息值对象列表
	 * @param jobInvitations
	 * @return
	 */
	public static List<JobInvitationVO> convertToJobInvitationVOs(List<JobInvitation> jobInvitations){
		List<JobInvitationVO> list = new ArrayList<JobInvitationVO>();
		for(JobInvitation jobInvitation:jobInvitations){
			JobInvitationVO jobInvitationVO = new JobInvitationVO();
			jobInvitationVO.setEnterpriseLogo(jobInvitation.getRecruitment()
					.getEnterprise().getLogo());
			jobInvitationVO.setEnterpriseName(jobInvitation.getRecruitment()
					.getEnterprise().getEnterpriseName());
			jobInvitationVO.setPostingName(jobInvitation.getRecruitment()
					.getPostingName());
			jobInvitationVO.setRecruitmentId(String.valueOf(jobInvitation
					.getRecruitment().getRecruitmentId()));
			jobInvitationVO.setSalary(jobInvitation.getRecruitment().getSalary()+"元左右");
			jobInvitationVO.setWorkingPlace(jobInvitation.getRecruitment().getWorkingPlace());
			list.add(jobInvitationVO);
		}
		return list;
	} 
	
}
