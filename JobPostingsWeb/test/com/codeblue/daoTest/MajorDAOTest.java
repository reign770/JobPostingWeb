package com.codeblue.daoTest;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.MajorDAO;
import com.codeblue.model.Major;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class MajorDAOTest extends AbstractJUnit4SpringContextTests{
	
	private MajorDAO majorDAO;
	
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
	public void testGetByMajorId() {
		System.out.println(majorDAO.getByMajorId(1));
	}

	@Test
	public void testQueryByDepartmentId() {
		List<Major> list = majorDAO.queryByDepartmentId(1);
		for(Major m:list) {
			System.out.println(m);
		}
	}

	public MajorDAO getMajorDAO() {
		return majorDAO;
	}
	
	@Resource
	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	
	
}
