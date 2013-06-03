package com.codeblue.vo;

public class EnterpriseVO {
	private String enterpriseId;//企业编号
	private String enterpriseName;//公司名称
	private String enterpriseLogo;//公司logo
	private String enterpriseProperty;//公司性质
	private String address;//公司地址
	private String registeredFund;//注册资金
	private String enterpriseScale;
	private String foundDate;//成立时间
	private String webSite;//公司网址
	private String brief;//公司简介
	private String followed;//是否关注
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getEnterpriseLogo() {
		return enterpriseLogo;
	}
	public void setEnterpriseLogo(String enterpriseLogo) {
		this.enterpriseLogo = enterpriseLogo;
	}
	public String getEnterpriseProperty() {
		return enterpriseProperty;
	}
	public void setEnterpriseProperty(String enterpriseProperty) {
		this.enterpriseProperty = enterpriseProperty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegisteredFund() {
		return registeredFund;
	}
	public void setRegisteredFund(String registeredFund) {
		this.registeredFund = registeredFund;
	}
	public String getEnterpriseScale() {
		return enterpriseScale;
	}
	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}
	public String getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getFollowed() {
		return followed;
	}
	public void setFollowed(String followed) {
		this.followed = followed;
	}
	@Override
	public String toString() {
		return "EnterpriseVO [enterpriseId=" + enterpriseId
				+ ", enterpriseName=" + enterpriseName + ", enterpriseLogo="
				+ enterpriseLogo + ", enterpriseProperty=" + enterpriseProperty
				+ ", address=" + address + ", registeredFund=" + registeredFund
				+ ", enterpriseScale=" + enterpriseScale + ", foundDate="
				+ foundDate + ", webSite=" + webSite + ", brief=" + brief
				+ ", followed=" + followed + "]";
	}
	
	

}
