package com.codeblue.service.enterprise;

import com.codeblue.model.Enterprise;

public interface Register {
	
	public boolean checkIfExist(String enterpriseAccount);
	
	public void register(Enterprise enterprise);
	
	public String getMsg();
	
}
