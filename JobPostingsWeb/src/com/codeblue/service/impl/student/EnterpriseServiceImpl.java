package com.codeblue.service.impl.student;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.dao.EvaluationDAO;
import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.Student;
import com.codeblue.service.student.EnterpriseService;
import com.codeblue.util.EnterpriseAddition;
import com.codeblue.util.PageBean;

@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService{
	
	private EnterpriseDAO enterpriseDAO;
	
	private StudentDAO studentDAO;
	
	private EvaluationDAO evaluationDAO;
	
	@Override
	public PageBean getConcernEnterprise(String studentId, int pageNumber,
			int pageSize) {
		List<Enterprise> list = enterpriseDAO.queryByStudentConcern(studentId, 
				(pageNumber-1)*pageSize, pageSize);
		long allRow = enterpriseDAO.getCountByStudentConcern(studentId);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNumber);
		pageBean.init();
		return pageBean;
	}

	@Override
	public void concernEnterprise(String studentId, int enterpriseId) {
		Student student = studentDAO.getByStudentId(studentId);
		Enterprise enterprise = enterpriseDAO.getByEnterpriseId(enterpriseId);
		student.getConcernEnterprises().add(enterprise);
		studentDAO.update(student);
	}

	@Override
	public void unconcernEnterprise(String studentId, int enterpriseId) {
		Student student = studentDAO.getByStudentId(studentId);
		Enterprise enterprise = enterpriseDAO.getByEnterpriseId(enterpriseId);
		student.getConcernEnterprises().remove(enterprise);
		studentDAO.update(student);
	}

	@Override
	public PageBean queryEnterprise(EnterpriseAddition enterpriseAddition,int pageNumber, int pageSize) {
		List<Enterprise> list = enterpriseDAO.queryByAddition(enterpriseAddition.getQueryWord(),
				                                              enterpriseAddition.getAddress(), 
				                                              enterpriseAddition.getProperty(), 
				                                              (pageNumber-1)*pageSize, pageSize);
		long allRow = enterpriseDAO.getCountByAddition(enterpriseAddition.getQueryWord(),
                									   enterpriseAddition.getAddress(), 
                									   enterpriseAddition.getProperty());
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setAllRow(allRow);
		pageBean.setPageSize(pageSize);
		pageBean.init();
		return pageBean;
	}

	@Override
	public void commentEnterpise(String studentId, int enterpriseId,
			String comment) {
		Evaluation evaluation = new Evaluation();
		evaluation.setContent(comment);
		evaluation.setPubdate(new Date());
		evaluation.setEnterpriseId(enterpriseId);
		Student student =new Student();
		student.setStudentId(studentId);
		evaluation.setStudent(student);
		evaluationDAO.insert(evaluation);
	}


	@Override
	public Boolean isConcernEnterprise(String studentId, int enterpriseId) {
		Student student = studentDAO.getByStudentId(studentId);
		Enterprise enterprise = enterpriseDAO.getByEnterpriseId(enterpriseId);
		if(student.getConcernEnterprises().contains(enterprise)) {
			return true;
		}
		return false;
	}

	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	@Resource
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Resource
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}
	@Resource
	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}

}
