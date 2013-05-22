package com.codeblue.service.impl.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.codeblue.dao.BriefDAO;
import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Brief;
import com.codeblue.model.Industry;
import com.codeblue.model.Student;
import com.codeblue.service.student.StudentInfoService;

@Repository
public class StudentInfoServiceImpl implements StudentInfoService {

	private StudentDAO studentDAO ;
	
	private BriefDAO briefDAO;
	
	@Override
	public int validLogin(String studentId, String password) {
		Student student = new Student();
		student = studentDAO.getByStudentId(studentId);
		if(student == null){
			return 2;
		}
		if(!student.getPassword().equals(password))
			return 3;
		else {
			return 1;
		}
	}

	@Override
	public int modifyBrief(Brief brief) {
		briefDAO.update(brief);
		return 0;
	}

	@Override
	public Student getStudent(String studentId) {
		return studentDAO.getByStudentId(studentId);
	}

	@Override
	public void modifyJobIntention(String studentId, int industryId) {
		Student student = studentDAO.getByStudentId(studentId);
		Industry industry = new Industry();
		industry.setIndustryId(industryId);
		student.setJobIntention(industry);
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Resource
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public BriefDAO getBriefDAO() {
		return briefDAO;
	}
	@Resource
	public void setBriefDAO(BriefDAO briefDAO) {
		this.briefDAO = briefDAO;
	}
	
	

	
}
