package com.codeblue.util;

public class EnterpriseAddition {
	
	private String queryWord;
	private String address;
	private String property;
	
	public void init(){
		if(queryWord != null){
			queryWord = queryWord.trim();
			if(queryWord.equals(""))
				queryWord=null;
		}
		if(address != null){
			address = address.trim();
			if(address.equals(""))
				address =null;
		}
		if(property != null){
			property = property.trim();
			if(property.equals(""))
				property =null;
		}
	}
	public String getQueryWord() {
		return queryWord;
	}
	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
}
