package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.RecruitmentDAO;
import com.codeblue.model.Recruitment;
import com.codeblue.model.property.EnterpriseProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class RecruitmentDAOTest extends AbstractJUnit4SpringContextTests{
	private RecruitmentDAO recruitmentDAO;
	
	@Test
	public void testGetByRecruitmentId() {
		fail("Not yet implemented");
	}

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
	public void testQueryByIndustry() {
		List<Recruitment> list = recruitmentDAO.queryByIndustry(1, 0, 10);
		for(Recruitment r:list) {
			System.out.println(r);
		}
	}

	@Test
	public void testGetCountByIndustry() {
		System.out.println(recruitmentDAO.getCountByIndustry(1));
	}

	@Test
	public void testQueryByEnterpriseId() {
		List<Recruitment> list = recruitmentDAO.queryByEnterpriseId(1, new Integer[]{1},0, 10);
		for(Recruitment r: list) {
			System.out.println(r);
		}
	}

	@Test
	public void testGetCountByEnterpriseId() {
		System.out.println(recruitmentDAO.getCountByEnterpriseId(1, new Integer[]{1}));
	}

	@Test
	public void testQueryByStudentId() {
		List<Recruitment> list = recruitmentDAO.queryByStudentId("10060130", 0, 10);
		for(Recruitment r:list) {
			System.out.println(r);
		}
	}

	@Test
	public void testGetCountByStudentId() {
		System.out.println(recruitmentDAO.getCountByStudentId("10060130"));
	}

	@Test
	public void testQueryByAddition() {
		List<Recruitment> list = 
		recruitmentDAO.queryByAddition("巨人", null, null, null,null, 2,0, 100);
		for(Recruitment r:list) {
			System.out.println(r);
		}
	}

	@Test
	public void testGetCountByAddition() {
		fail("Not yet implemented");
	}

	public RecruitmentDAO getRecruitmentDAO() {
		return recruitmentDAO;
	}
	@Resource
	public void setRecruitmentDAO(RecruitmentDAO recruitmentDAO) {
		this.recruitmentDAO = recruitmentDAO;
	}
	
	

}
