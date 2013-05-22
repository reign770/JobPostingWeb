package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.dao.impl.JobApplicationDAOImpl;
import com.codeblue.model.JobApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class JobApplicationDAOTest extends AbstractJUnit4SpringContextTests{
	
	private JobApplicationDAO jobApplicationDAO;
	
	@Test
	public void testGetByJobApplicationId() {
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
	public void testQueryByStudentId() {
		List<JobApplication> list = 
		jobApplicationDAO.queryByStudentId("10060130", new Integer[]{0,1,2,3}, 0, 10);
		for(JobApplication j:list) {
			System.out.println(j);
		}
	}

	@Test
	public void testGetCountByStudentId() {
		System.out.println(jobApplicationDAO.
				getCountByStudentId("10060130", new Integer[]{0,1,2}));
	}

	@Test
	public void testQueryByEnterpriseId() {
		List<JobApplication> list = jobApplicationDAO
				.queryByEnterpriseId(1, new Integer[]{0,1,2}, 0, 10);
		for(JobApplication j: list) {
			System.out.println(j);
		}
	}

	@Test
	public void testGetCountByEnterpriseId() {
		System.out.println(jobApplicationDAO
				.getCountByEnterpriseId(1, new Integer[]{0,1,2}));
	}

	@Test
	public void testQueryByRecruitmentId() {
		List<JobApplication> list = jobApplicationDAO.queryByRecruitmentId(1, new Integer[]{0,1,2}, 0, 10);
		for(JobApplication j: list) {
			System.out.println(j);
		}
	}

	@Test
	public void testGetCountByRecruitmentId() {
		System.out.println(jobApplicationDAO.getCountByRecruitmentId(1, new Integer[]{0,1,2}));
	}
	
	
	@Test
	public void getByJobApplicationFK(){
		System.out.println(jobApplicationDAO.getByJobApplicationFK("10060130", 1));
	}

	public JobApplicationDAO getJobApplicationDAO() {
		return jobApplicationDAO;
	}
	@Resource
	public void setJobApplicationDAO(JobApplicationDAO jobApplicationDAO) {
		this.jobApplicationDAO = jobApplicationDAO;
	}
	
	

}
