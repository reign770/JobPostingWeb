package com.codeblue.daoTest;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Department;
import com.codeblue.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class StudentDAOTest extends AbstractJUnit4SpringContextTests{
	
	private StudentDAO studentDAO;
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByStudentId() {
		System.out.println(studentDAO.getByStudentId("10060130"));
	}

	@Test
	public void testQueryByJobIntention() {
		List<Student> list = studentDAO.queryByJobIntention(1, 0, 10);
		for(Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testGetCountByJobIntention() {
		System.out.println(studentDAO.getCountByJobIntention(1));
	}

	@Test
	public void testQueryByDepartment() {
		List<Student> list = studentDAO.queryByDepartment(1, 0, 10);
		for(Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testGetCountByDepartment() {
		System.out.println(studentDAO.getCountByDepartment(1));
	}

	@Test
	public void testQueryByMajor() {
		List<Student> list = studentDAO.queryByMajor(1, 0, 10);
		for(Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void testGetCountByMajor() {
		System.out.println(studentDAO.getCountByMajor(1));
	}

	@Test
	public void testQueryByClass() {
		List<Student> list = studentDAO.queryByMajor(1, 0, 3);
		for(Student student : list){
			System.out.println(student);
		}
	}

	@Test
	public void testGetCountByClass() {
		System.out.println(studentDAO.getCountByClass(1));
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Resource
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	

}
