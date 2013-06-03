package com.codeblue.service.impl.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Student;
import com.codeblue.service.enterprise.StudentService;
import com.codeblue.util.PageBean;

@Service("ent_studentService")
public class StudentServiceImpl implements StudentService {
	@Resource(name="studentDAO")
	private StudentDAO studentDAO;
	
	@Override
	public PageBean queryStudentsOfAClass(int classId,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		List<Student> students=studentDAO.queryByClass(classId, (pageNum-1)*pageSize, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.setList(students);
		pageBean.setAllRow(studentDAO.getCountByClass(classId));
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

	@Override
	public PageBean queryRecommandStudentsByJobIntention(int industryId,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Student> students=studentDAO.queryByJobIntention(industryId,  (pageNum-1)*pageSize, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.setList(students);
		pageBean.setAllRow(studentDAO.getCountByJobIntention(industryId));
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNum);
		pageBean.init();
		return pageBean;
	}

}
