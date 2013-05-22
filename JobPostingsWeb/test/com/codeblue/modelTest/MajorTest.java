package com.codeblue.modelTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.model.Department;
import com.codeblue.model.Major;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class MajorTest extends AbstractJUnit4SpringContextTests{
	HibernateTemplate hibernateTemplate;
	@Test
	public void insertTest(){
		Department department = new Department();
		department.setDepartmentId(1);
		String[] strs =new String[]{"电子信息工程","通信工程"};
		for(String majorName:strs){
			Major major = new Major();
			major.setDepartment(department);
			major.setMajorName(majorName);
			hibernateTemplate.save(major);
		}
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
