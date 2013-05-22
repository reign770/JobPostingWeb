package com.codeblue.modelTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class DepartmentTest extends AbstractJUnit4SpringContextTests{
	private HibernateTemplate hibernateTemplate ;
	@Test
	public void insertTest(){
		String[] str = new String[]{"土木建筑学院","河海学院","机电与汽车工程学院","财经学院","人文学院",
									"外国语学院"," 理学院","航海学院"};
		for(String s:str){
			Department department = new Department();
			department.setDepartmentName(s);
			hibernateTemplate.save(department);
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
