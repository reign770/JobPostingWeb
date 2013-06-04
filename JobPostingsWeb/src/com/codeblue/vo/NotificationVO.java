package com.codeblue.vo;

public class NotificationVO {
	
	private String notificationId;
	private String enterpriseLogo;
	private String enterpriseId;
	private String enterpriseName;
	private String content;
	private String postTime;
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public String getEnterpriseLogo() {
		return enterpriseLogo;
	}
	public void setEnterpriseLogo(String enterpriseLogo) {
		this.enterpriseLogo = enterpriseLogo;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	@Override
	public String toString() {
		return "NotificationVO [notificationId=" + notificationId
				+ ", enterpriseLogo=" + enterpriseLogo + ", enterpriseId="
				+ enterpriseId + ", enterpriseName=" + enterpriseName
				+ ", content=" + content + ", postTime=" + postTime + "]";
	}
	
}
