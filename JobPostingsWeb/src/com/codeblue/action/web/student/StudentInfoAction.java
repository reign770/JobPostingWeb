package com.codeblue.action.web.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.mapping.Array;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Brief;
import com.codeblue.model.Industry;
import com.codeblue.model.Student;
import com.codeblue.service.student.RecruitmentService;
import com.codeblue.service.student.StudentInfoService;
import com.codeblue.util.ResumeUntil;
import com.codeblue.vo.Resume;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentInfoAction")
public class StudentInfoAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -1150246590972142316L;
	
	private String studentId;
	private String password;
	private int jobIntentionId;
	private List<Industry> industries;
	private Student student;
	private StudentInfoService studentInfoService;
	private RecruitmentService recruitmentService;
	private Resume resume;
	private Map<String, Object> session;
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String showStudentInfo() {
		if(studentId==null && studentId.equals(""))
			return "nostudent";
		student = studentInfoService.getStudent(studentId);
		if(student==null)
			return "nostudent";
		else {
			return "getinfo";
		}
	}
	//获取简历信息
	public String showBrief() {
	    //获取所有行业
		industries = recruitmentService.getAllIndustries();
		Student student  = (Student)session.get("student");
		resume = ResumeUntil.changeToResume(
				student.getBrief());
		jobIntentionId = student.getJobIntention().getIndustryId();
		return "show_brief";
	}
	//修改简历
	public String modifyBrief() {
	    if(resume ==null)
	    	resume = new Resume();
	    Brief brief = ResumeUntil.changeToBrief(resume);
	    Student student = (Student)session.get("student");
	    brief.setStudentId(student.getStudentId());
		studentInfoService.modifyBrief(brief);
		studentInfoService.modifyJobIntention(student.getStudentId(), jobIntentionId);
		//更新session
		Industry jobIntention = new Industry();
		jobIntention.setIndustryId(jobIntentionId);
		System.err.println("industryId:"+jobIntentionId);
		student.setJobIntention(jobIntention);
		student.setBrief(brief);
		brief.setStudent(student);
		session.put("student", student);
		return SUCCESS;
	}
	//修改密码
	public String modifyPassword() {
		Student student = (Student)session.get("student"); 
		studentInfoService.modifyPassword(
				student.getStudentId(), 
				password);
		//更新session
		student.setPassword(password);
		session.put("student", student);
		return "modifypassword_success";
	}
	

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public int getJobIntentionId() {
		return jobIntentionId;
	}

	public void setJobIntentionId(int jobIntentionId) {
		this.jobIntentionId = jobIntentionId;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	@Resource
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}
	@Resource
	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}

	public List<Industry> getIndustries() {
		return industries;
	}
	
	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}
	
	
	
	

}
