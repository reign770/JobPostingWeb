package com.codeblue.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
	private String studentId;
	private String password;
	private int state;
	private String name;
	private String sex;
	private String headImage;//头像
	private Date birthday;//生日
	private String email;//邮箱
	private String nation;
	private String degree;//学历
	private String telephone;
	private String idNum;//身份证号码
	private Date graduationDate;
	private String address;//住址
	private float gpa;//平均绩点
	private String school;
	private Class schoolClass;
	private Brief brief;
	private Industry jobIntention;
	private Set<Enterprise> concernEnterprises = new HashSet<Enterprise>();//关注企业
	private Set<Notification> notifications = new HashSet<Notification>();
	@Id
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getHeadImage() {
		return headImage;
	}
	
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getNation() {
		return nation;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getIdNum() {
		return idNum;
	}
	
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
	public Date getGraduationDate() {
		return graduationDate;
	}
	
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getGpa() {
		return gpa;
	}
	
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	@ManyToOne
	@JoinColumn(name="classId")
	public Class getSchoolClass() {
		return schoolClass;
	}
	
	public void setSchoolClass(Class schoolClass) {
		this.schoolClass = schoolClass;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public Brief getBrief() {
		return brief;
	}
	
	public void setBrief(Brief brief) {
		this.brief = brief;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="concernEnterprise",
		joinColumns={@JoinColumn(name="studentId")},
		inverseJoinColumns={@JoinColumn(name="enterpriseId")}
			)
	
	public Set<Enterprise> getConcernEnterprises() {
		return concernEnterprises;
	}
	
	public void setConcernEnterprises(Set<Enterprise> concernEnterprises) {
		this.concernEnterprises = concernEnterprises;
	}
	
	
	@ManyToOne
	@JoinColumn(name="industryId")
	public Industry getJobIntention() {
		return jobIntention;
	}
	
	public void setJobIntention(Industry jobIntention) {
		this.jobIntention = jobIntention;
	}
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="studentId")
	public Set<Notification> getNotifications() {
		return notifications;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", password=" + password
				+ ", state=" + state + ", name=" + name + ", sex=" + sex
				+ ", headImage=" + headImage + ", birthday=" + birthday
				+ ", nation=" + nation + ", degree=" + degree + ", telephone="
				+ telephone + ", idNum=" + idNum + ", graduationDate="
				+ graduationDate + ", address=" + address + ", gpa=" + gpa
				+ ", school=" + school + ", schoolClass=" + schoolClass
				+ ", brief=" + brief + ", jobIntention=" + jobIntention + "]";
	}

	
}
