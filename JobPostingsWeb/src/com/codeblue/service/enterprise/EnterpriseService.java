package com.codeblue.service.enterprise;

import com.codeblue.model.Enterprise;

/**
 * 
 * @author 周奥特
 * @datetime 2013-5-20 下午10:41:49
 */
public interface EnterpriseService {
	
	public Enterprise queryEnterprise(int enterpriseId);
	
	public void updateEnterprise(Enterprise enterprise);
	
	

}
