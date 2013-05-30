package com.codeblue.util;

import org.apache.commons.lang.ObjectUtils.Null;

import com.sun.org.apache.xml.internal.security.Init;

public class QueryAddition {
	private String queryWord;
	private String postingName;
	private String workingPlace;
	private Integer salary;
	private String enterpriseProperty;
	private int industryId;
	public void init(){
		if(queryWord != null)
		queryWord =queryWord.trim();
		if(postingName != null)
		postingName = postingName.trim();
		if(workingPlace != null)
		workingPlace = workingPlace.trim();
		if(enterpriseProperty !=null)
		enterpriseProperty = enterpriseProperty.trim();
		if(salary==null||salary <=0)
			salary=null;
		if(industryId < 0)
			industryId =0;
	}
	public String getQueryWord() {
		return queryWord;
	}
	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}
	public String getPostingName() {
		return postingName;
	}
	public void setPostingName(String postingName) {
		this.postingName = postingName;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEnterpriseProperty() {
		return enterpriseProperty;
	}
	public void setEnterpriseProperty(String enterpriseProperty) {
		this.enterpriseProperty = enterpriseProperty;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	
	
}
