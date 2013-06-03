package com.codeblue.vo;

public class EnterpriseItemVO {
	private int enterpriseId;
	private String enterpirseName;
	private String enterpriseLogo;
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpirseName() {
		return enterpirseName;
	}
	public void setEnterpirseName(String enterpirseName) {
		this.enterpirseName = enterpirseName;
	}
	public String getEnterpriseLogo() {
		return enterpriseLogo;
	}
	public void setEnterpriseLogo(String enterpriseLogo) {
		this.enterpriseLogo = enterpriseLogo;
	}
	@Override
	public String toString() {
		return "EnterpriseItemVO [enterpriseId=" + enterpriseId
				+ ", enterpirseName=" + enterpirseName + ", enterpriseLogo="
				+ enterpriseLogo + "]";
	}
	

}
