package com.codeblue.model;

import java.util.Date;

import javax.persistence.*;
@Entity
public class EmployeementInfo {
	private int infoId;
	private String title;
	private String info;
	private Date releaseDate;
	private Administrator administrator;
	@Id
	@GeneratedValue
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account")
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	@Override
	public String toString() {
		return "EmployeementInfo [infoId=" + infoId + ", title=" + title
				+ ", info=" + info + ", releaseDate=" + releaseDate + "]";
	}
	
}
