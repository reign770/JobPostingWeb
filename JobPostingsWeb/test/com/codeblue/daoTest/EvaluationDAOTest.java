package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.EvaluationDAO;
import com.codeblue.model.Evaluation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class EvaluationDAOTest extends AbstractJUnit4SpringContextTests{
	
	private EvaluationDAO evaluationDAO;
	
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
	public void testQueryByEnterpriseId() {
		List<Evaluation> list = 
				evaluationDAO.queryByEnterpriseId(1, 0, 10);
		for(Evaluation e: list){
			System.out.println(e);
		}
	}

	@Test
	public void testGetCountByEnterpriseId() {
			System.out.println(evaluationDAO.getCountByEnterpriseId(1));
	}

	@Test
	public void testQueryByStudentId() {
		List<Evaluation> list = evaluationDAO.queryByStudentId("10060130", 0, 10);
		for(Evaluation e:list){
			System.out.println(e);
		}
	}

	@Test
	public void testGetCountByStudentId() {
		System.out.println(evaluationDAO.getCountByStudentId("10060130"));
	}

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}
	@Resource
	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}
	
	

}
