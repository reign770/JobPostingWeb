package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.ClassDAO;
import com.codeblue.model.Class;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ClassDAOTest extends AbstractJUnit4SpringContextTests{
	private ClassDAO classDAO;
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
	public void testQueryByMajor() {
		List<Class> list = classDAO.queryByMajor(1, 0, 10);
		for(Class class1 : list){
			System.out.println(class1);
		}
	}

	@Test
	public void testGetCountByMajor() {
		long b = classDAO.getCountByMajor(1);
		System.out.println(b);
	}

	public ClassDAO getClassDAO() {
		return classDAO;
	}
	@Resource
	public void setClassDAO(ClassDAO classDAO) {
		this.classDAO = classDAO;
	}
	
	

}
