package com.codeblue.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Enterprise {
	private int enterpriseId;
	private String enterpriseAccount;
	private String password;
	private int state; //账号状态
	private String logo;    //logo的url
	private String enterpriseName;//企业名称
	private Date foundDate;
	private String enterpriseProperty;
	private float registeredFund;//注册资金
	private String address; //地址
	private String linkman;//联系人
	private String phone;//联系人电话
	private String fax;//传真
	private String webSite;//公司网址
	private String enterpriseLegalPerson;//企业法人
	private String enterpriseScale;//企业规模
	private String businessLicenseId; //营业执照编号
	private String brief;//简介
	private Date registerDate;//账号注册时间
	private List<Recruitment> recruitments = new ArrayList<Recruitment>();//招聘信息
	private List<Evaluation> evaluations = new ArrayList<Evaluation>(); //评论
	@Id
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	
	public String getEnterpriseAccount() {
		return enterpriseAccount;
	}

	public void setEnterpriseAccount(String enterpriseAccount) {
		this.enterpriseAccount = enterpriseAccount;
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
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getEnterpriseName() {
		return enterpriseName;
	}
	
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	public Date getFoundDate() {
		return foundDate;
	}
	
	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}
	
	public String getEnterpriseProperty() {
		return enterpriseProperty;
	}
	
	public void setEnterpriseProperty(String enterpriseProperty) {
		this.enterpriseProperty = enterpriseProperty;
	}
	
	public float getRegisteredFund() {
		return registeredFund;
	}
	
	public void setRegisteredFund(float registeredFund) {
		this.registeredFund = registeredFund;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLinkman() {
		return linkman;
	}
	
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
		
	public String getEnterpriseScale() {
		return enterpriseScale;
	}

	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}

	public String getWebSite() {
		return webSite;
	}
	
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	public String getEnterpriseLegalPerson() {
		return enterpriseLegalPerson;
	}
	
	public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
		this.enterpriseLegalPerson = enterpriseLegalPerson;
	}
	
	public String getBusinessLicenseId() {
		return businessLicenseId;
	}
	
	public void setBusinessLicenseId(String businessLicenseId) {
		this.businessLicenseId = businessLicenseId;
	}
	
	public String getBrief() {
		return brief;
	}
	
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@OneToMany(mappedBy="enterprise",fetch=FetchType.LAZY)
	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}
	@OneToMany(mappedBy="enterpriseId",fetch=FetchType.LAZY)
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	@Override
	public String toString() {
		return "Enterprise [enterpriseId=" + enterpriseId
				+ ", enterpriseAccount=" + enterpriseAccount + ", password="
				+ password + ", state=" + state + ", logo=" + logo
				+ ", enterpriseName=" + enterpriseName + ", foundDate="
				+ foundDate + ", enterpriseProperty=" + enterpriseProperty
				+ ", registeredFund=" + registeredFund + ", address=" + address
				+ ", linkman=" + linkman + ", phone=" + phone + ", fax=" + fax
				+ ", webSite=" + webSite + ", enterpriseLegalPerson="
				+ enterpriseLegalPerson + ", enterpriseScale="
				+ enterpriseScale + ", businessLicenseId=" + businessLicenseId
				+ ", brief=" + brief + ", registerDate=" + registerDate + "]";
	}
	
	
	
}
