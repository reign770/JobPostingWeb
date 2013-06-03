package com.codeblue.vo;

import java.util.Arrays;


public class StudentVO {
	private String studentId;
	private String name;
	private String sex;
	private String telephone;
	private String birthday;
	private String email;
	private String idNum;
	private String school;
	private String address;
	private String headImage;
	private String graduationDate;
	private String gpa;
	private String degree;
	private String nation;
	private String DepartmentName;
	private String majorName;
	private String className;
	private String[] majorCourse;
	private String[] honor;
	private String[] experience;
	private String[] interests;
	private String resume;
	
	
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String[] getMajorCourse() {
		return majorCourse;
	}
	public void setMajorCourse(String[] majorCourse) {
		this.majorCourse = majorCourse;
	}
	public String[] getHonor() {
		return honor;
	}
	public void setHonor(String[] honor) {
		this.honor = honor;
	}
	public String[] getExperience() {
		return experience;
	}
	public void setExperience(String[] experience) {
		this.experience = experience;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "StudentVO [studentId=" + studentId + ", name=" + name
				+ ", sex=" + sex + ", telephone=" + telephone + ", birthday="
				+ birthday + ", email=" + email + ", idNum=" + idNum
				+ ", school=" + school + ", address=" + address
				+ ", headImage=" + headImage + ", graduationDate="
				+ graduationDate + ", gpa=" + gpa + ", degree=" + degree
				+ ", nation=" + nation + ", DepartmentName=" + DepartmentName
				+ ", majorName=" + majorName + ", className=" + className
				+ ", majorCourse=" + Arrays.toString(majorCourse) + ", honor="
				+ Arrays.toString(honor) + ", experience="
				+ Arrays.toString(experience) + ", interests="
				+ Arrays.toString(interests) + ", resume=" + resume + "]";
	}
	

}
