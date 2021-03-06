package com.codeblue.action.app;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Brief;
import com.codeblue.model.Student;
import com.codeblue.service.enterprise.StudentService;
import com.codeblue.service.student.StudentInfoService;
import com.codeblue.util.ResumeUntil;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.Resume;
import com.codeblue.vo.Status;
import com.codeblue.vo.StudentVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("app_studentInfoAction")
public class StudentInfoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6336607918527414478L;
	public final static String SUCCEED = "succeed";
	public final static String FAIL = "fail";
	
	//传入参数
	private String username;//学生账号
	private String studentId;//学生学号
	private String password;//密码
	private String newPassword;
	private String[] majorCourse;
	private String[] honor;
	private String[] experience;
	private String[] interests;
	private String resume;
	private int industryId;
	
	private Student student;
	
	private StudentVO studentVO;//学生值对象
	private Status status = new Status();//状态
	private StudentInfoService studentInfoService;
	
	public String login() {
		int flag =
		studentInfoService.validLogin(username, password);
		if(flag == 1) {
			status.setStatus(SUCCEED);
		}
		else {
			status.setStatus(FAIL);
		}
		return "result";
	}
	
	public String showInfo() {
		studentVO = VOUntil.convertToStudentVO(
				studentInfoService.getStudent(studentId));
		
		return "studentInfo";
	}
	public String previewResume(){
		student = studentInfoService.getStudent(studentId);
		return "resume";
	}
	
	public String modifyBrief() {
		System.err.println("interests:");
		print(interests);
		System.err.println("experience:");
		print(experience);
		System.err.println("majorCourse:");
		print(majorCourse);
		System.err.println("honors:");
		print(honor);
		System.err.println("resume:"+resume);
		Resume resumeInfo = new Resume();
		resumeInfo.setStudentId(studentId);
		resumeInfo.setHonors(honor);
		resumeInfo.setExperience(experience);
		resumeInfo.setInterests(interests);
		resumeInfo.setMajorCourse(majorCourse);
		resumeInfo.setResume(resume);
		Brief brief = ResumeUntil.changeToBrief(resumeInfo);
		studentInfoService.modifyBrief(brief);
		studentInfoService.modifyJobIntention(studentId, industryId);
		status = new Status();
		status.setStatus(SUCCEED);
		return "result";
	}
	
	public String modifyPassword(){
		studentInfoService.modifyPassword(studentId, newPassword);
		status.setStatus(SUCCEED);
		return "result";
	}
	public void print(String[] strs){
		if(strs!= null)
			for(String s:strs)
			System.err.println(s);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	

	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public StudentVO getStudentVO() {
		return studentVO;
	}
	
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	
	
	public String[] getMajorCourse() {
		return majorCourse;
	}

	public void setMajorCourse(String[] majorCourse) {
		this.majorCourse = majorCourse;
	}

	public String[] getHonor() {
		return honor;
	}

	public void setHonor(String[] honor) {
		this.honor = honor;
	}

	public String[] getExperience() {
		return experience;
	}

	public void setExperience(String[] experience) {
		this.experience = experience;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	
	@Resource
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}


	
	
	
	

}
