package com.codeblue.modelTest;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.model.Administrator;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Evaluation;
import com.codeblue.model.JobApplication;
import com.codeblue.model.JobInvitation;
import com.codeblue.model.Notification;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class QueryTest extends AbstractJUnit4SpringContextTests{
	private HibernateTemplate hibernateTemplate;
	@Test
	public void testAdministrator(){
		Administrator administrator = 
				(Administrator)hibernateTemplate.get(Administrator.class, "reignljq");
		System.out.println(administrator);
		
	}
	@Test
	public void testStudent(){
		Student student = (Student)hibernateTemplate.get(Student.class, "10060130");
		System.out.println(student);
		Enterprise enterprise = (Enterprise)hibernateTemplate.get(Enterprise.class, 2);
		student.getConcernEnterprises().add(enterprise);
		hibernateTemplate.update(student);
	}
	@Test
	public void testNotification(){
//		Enterprise enterprise = (Enterprise)hibernateTemplate.get(Enterprise.class, 2);
//		Notification notification = new Notification();
//		notification.setContent("恭喜你!你已经通过该公司的面试");
//		notification.setEnterprise(enterprise);
//		notification.setPostTime(new Date());
//		notification.setState(0);
//		notification.setStudentId("10060130");
//		hibernateTemplate.save(notification);
		Student student = (Student)hibernateTemplate.get(Student.class, "10060130");
		Iterator<Notification> iterator = student.getNotifications().iterator();
		int count=0;
		while(iterator.hasNext()){
			Notification notification = iterator.next();
			System.out.println(notification);
			count++;
		}
		System.out.println(count);
	}
	
	@Test
	public void testRecruitment(){
		List<Recruitment> list = hibernateTemplate.find("from Recruitment r where r.enterprise.enterpriseId=?", 1);
		Iterator<Recruitment> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	@Test
	public void testJobApplication(){
		List<JobApplication> list = hibernateTemplate.find("from JobApplication j where j.recruitment.enterprise.enterpriseId=?",1);
		Iterator<JobApplication> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}		
	}

	@Test
	public void testJobInvitation(){
		List<JobInvitation> list = hibernateTemplate.find("from JobInvitation j where j.student.studentId=?","10060130");
		Iterator<JobInvitation> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}				
	}
	@Test
	public void testEvaluation(){
		List<Evaluation> list = hibernateTemplate.find("from Evaluation e where e.enterpriseId=?",1);
		Iterator<Evaluation> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
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
