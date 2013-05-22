package com.codeblue.modelTest;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.model.*;
import com.codeblue.model.Class;
import com.sun.org.apache.regexp.internal.recompile;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ModelTest extends AbstractJUnit4SpringContextTests{
	private static HibernateTemplate hibernateTemplate;
	
	@Test
	public void testDepartment(){
		Department department = new Department();
		department.setDepartmentName("信息学院");
		department.setDepartmentInfo("最悲剧的学院，被忽视的学院");
		hibernateTemplate.save(department);
	}
	@Test
	public void testMajor(){
		Major major = new Major();
		major.setMajorName("计算机科学与技术");
		Department department = new Department();
		department.setDepartmentId(1);
		major.setDepartment(department);
		hibernateTemplate.save(major);
	}
	
	@Test
	public void testClass(){
		Major major = new Major();
		major.setMajorId(1);
		Class class1 = new Class();
		class1.setClassName("软件一班");
		class1.setMajor(major);
		class1.setGrade(2010);
		hibernateTemplate.save(class1);
		
	}
	
	@Test
	public void testAdministrator(){
		Administrator administrator = new Administrator();
		administrator.setAccount("reignljq");
		administrator.setPassword("123456");
		hibernateTemplate.save(administrator);
	}
	@Test
	public void testStudent(){
	    Student student = new Student();
		student.setStudentId("10060130");
		student.setPassword(student.getStudentId());
		student.setSex("男");
		student.setState(0);
		student.setAddress("重庆");
		student.setBirthday(new Date("1991/5/14"));
		student.setDegree("本科");
		student.setGpa(3.8f);
		student.setGraduationDate(new Date("2014/5/1"));
		student.setHeadImage("/headImage.jpg");
		student.setIdNum("134141342");
		student.setName("李佳奇");
		student.setNation("汉族");
		student.setSchool("重庆交通大学");
		student.setTelephone("199432423412");
		Class class1 = new Class();
		class1.setClassId(1);
		student.setSchoolClass(class1);
		hibernateTemplate.save(student);
	}
	
	@Test
	public void testBrief(){
		Brief brief = new Brief();
		Student student = new Student();
		brief.setStudentId("10060130");
		student.setStudentId("10060130");
		brief.setExperience("无");
		brief.setHonor("无");
		brief.setInterests("无");
		brief.setMajorCourse("高数");
		brief.setResume("e");
		brief.setStudent(student);
		hibernateTemplate.save(brief);
	}

	@Test
	public void testEnterprise(){
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseAccount("dayfly");
		enterprise.setAddress("北京中关村");
		enterprise.setBrief("无");
		enterprise.setEnterpriseLegalPerson("李克农");
		enterprise.setEnterpriseName("巨人集团");
		enterprise.setEnterpriseProperty("私营");
		enterprise.setFax("00342");
		enterprise.setFoundDate(new Date("1991/5/14"));
		enterprise.setLinkman("李先生");
		enterprise.setLogo("/default.jpg");
		enterprise.setState(1);
		enterprise.setBusinessLicenseId("1fdsfas");
		enterprise.setEnterpriseScale("大型");
		enterprise.setPassword("123");
		enterprise.setPhone("65197865");
		enterprise.setRegisterDate(new Date());
		enterprise.setRegisteredFund(500f);
		hibernateTemplate.save(enterprise);
	}
	
	@Test
	public void testIndustry(){
		Industry industry = new Industry();
		industry.setJobType("会计");
		hibernateTemplate.save(industry);
	}
	
	@Test
	public void testRecruitment(){
		Recruitment recruitment = new Recruitment();
		recruitment.setAge("26-29");
		recruitment.setDeadline(new Date("2014/6/20"));
		recruitment.setDegree("本科以上");
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(1);
		recruitment.setEnterprise(enterprise);
		recruitment.setForeignLanguage("英语四级");
		Industry industry = new Industry();
		industry.setIndustryId(1);
		recruitment.setIndustry(industry);
		recruitment.setSalary(10000);
		recruitment.setSex("不限");
		recruitment.setWorkExperience("不限");
		recruitment.setWorkingPlace("重庆");
		recruitment.setPostingName("软件架构师");
		recruitment.setQualification("无");
		recruitment.setRecruitmentCount(6);
		recruitment.setReleaseDate(new Date());
		recruitment.setResponsibilities("无");
		hibernateTemplate.save(recruitment);
	}
	
	@Test
	public void testEmployeementInfo(){
		Administrator administrator = new Administrator();
		administrator.setAccount("reignljq");
		EmployeementInfo employeementInfo = new EmployeementInfo();
		employeementInfo.setAdministrator(administrator);
		employeementInfo.setInfo("大招生");
		employeementInfo.setTitle("第一弹");
		employeementInfo.setReleaseDate(new Date());
		hibernateTemplate.save(employeementInfo);
	}
	

	@Test
	public void testJobApplication(){
		Recruitment recruitment = 
				(Recruitment)hibernateTemplate.get(Recruitment.class, 1);
		Student student =(Student)hibernateTemplate.get(Student.class, "10060130");
		JobApplication jobApplication = new JobApplication();
		jobApplication.setRecruitment(recruitment);
		jobApplication.setStudent(student);
		jobApplication.setApplyDate(new Date());
		jobApplication.setState(0);
		jobApplication.setContent("null");
		hibernateTemplate.save(jobApplication);
	}
	@Test
	public void testJobInvitation(){
		Recruitment recruitment = 
				(Recruitment)hibernateTemplate.get(Recruitment.class, 1);
		Student student =(Student)hibernateTemplate.get(Student.class, "10060130");
		JobInvitation jobInvitation = new JobInvitation();
		jobInvitation.setRecruitment(recruitment);
		jobInvitation.setStudent(student);
		jobInvitation.setInvitationDate(new Date());
		jobInvitation.setState(0);
		jobInvitation.setContent("欢饮来应聘本公司的职位!");
		hibernateTemplate.save(jobInvitation);
	}
	@Test
	public void testEvaluation(){
		Evaluation evaluation = new Evaluation();
		Student student = new Student();
		student.setStudentId("10060130");
		student.setStudentId("10060130");
		evaluation.setEnterpriseId(1);
		evaluation.setContent("NB!");
		evaluation.setPubdate(new Date());
		evaluation.setStudent(student);
		hibernateTemplate.save(evaluation);
	}
	@Test
	public void testNotification(){
		Notification notification = new Notification();
		notification.setContent("说什么好啦");
		notification.setPostTime(new Date());
		notification.setState(0);
		notification.setStudentId("10060130");
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(1);
		notification.setEnterprise(enterprise);
		hibernateTemplate.save(notification);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
