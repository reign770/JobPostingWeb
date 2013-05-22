package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.EmployeementInfoDAO;
import com.codeblue.model.EmployeementInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class EmployeementInfoDAOTest extends AbstractJUnit4SpringContextTests{
	private EmployeementInfoDAO employeementInfoDAO;
	
	@Test
	public void testGetAll() {
		List<EmployeementInfo> list = employeementInfoDAO.getAll(0, 10);
		for(EmployeementInfo employeementInfo:list){
			System.out.println(employeementInfo);
		}
	}
	
	@Test
	public void testGetCount(){
		System.out.println(employeementInfoDAO.getCount());
	}
	
	public EmployeementInfoDAO getEmployeementInfoDAO() {
		return employeementInfoDAO;
	}
	@Resource
	public void setEmployeementInfoDAO(EmployeementInfoDAO employeementInfoDAO) {
		this.employeementInfoDAO = employeementInfoDAO;
	}
	
	

}
