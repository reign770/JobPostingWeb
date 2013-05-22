package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.property.EnterpriseAccountState;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class EnterpriseDAOTest extends AbstractJUnit4SpringContextTests{
	
	private EnterpriseDAO enterpriseDAO;
	
	@Test
	public void testGetEnterpriseByAccount() {
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
	public void testQueryByStudentConcern() {
		List<Enterprise> list = enterpriseDAO.queryByStudentConcern("10060130", 0, 10);
		if(list == null){
			System.out.println("null");
		}
		else
		for(Enterprise enterprise:list){
			System.out.println(enterprise);
		}
	}
	

	@Test
	public void testGetCountByStudentConcern() {
		System.out.println(enterpriseDAO.getCountByStudentConcern("10060130"));
	}

	@Test
	public void testQueryByAddition() {
		List<Enterprise> list = 
				enterpriseDAO.queryByAddition("腾", null, null, 0, 10);
		for(Enterprise enterprise:list){
			System.out.println(enterprise);
		}
	}

	@Test
	public void testGetCountByAddition() {
		System.out.println(enterpriseDAO.getCountByAddition("腾讯", null, null));
	}

	
	@Test
	public void testQueryAll() {
		List<Enterprise> list = 
				enterpriseDAO.queryAll(new Integer[]{EnterpriseAccountState.PASS}, 0, 10);
		for(Enterprise enterprise : list) {
			System.out.println(enterprise);
		}
	}
	
	@Test
	public void testGetCount() {
		System.out.println(enterpriseDAO.getCount(new Integer[]{EnterpriseAccountState.PASS}));
	}
	
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	
	@Resource
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	
	

}
