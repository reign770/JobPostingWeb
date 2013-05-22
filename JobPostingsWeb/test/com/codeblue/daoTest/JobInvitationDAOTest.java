package com.codeblue.daoTest;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.JobInvitationDAO;
import com.codeblue.model.JobInvitation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class JobInvitationDAOTest extends AbstractJUnit4SpringContextTests{
	
	private JobInvitationDAO jobInvitationDAO;
	@Test
	public void testGetByInvitationId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByJobInvitationFK() {
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
		List<JobInvitation> list = 
				jobInvitationDAO.queryByStudentId("10060130", new Integer[]{0,1,2,3},0, 1);
		for(JobInvitation j:list){
			System.out.println(j);
		}
	}

	@Test
	public void testGetCountByStudentId() {
		System.out.println(jobInvitationDAO.getCountByStudentId("10060130", new Integer[]{0,1,2,3}));
	}

	public JobInvitationDAO getJobInvitationDAO() {
		return jobInvitationDAO;
	}
	
	@Resource
	public void setJobInvitationDAO(JobInvitationDAO jobInvitationDAO) {
		this.jobInvitationDAO = jobInvitationDAO;
	}
	
	

}
