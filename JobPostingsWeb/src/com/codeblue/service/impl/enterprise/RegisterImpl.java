package com.codeblue.service.impl.enterprise;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.Register;
@Service("ent_register")
public class RegisterImpl implements Register {
	private String msg;
	
	@Resource(name="enterpriseDAO")
	private EnterpriseDAO enterpriseDAO;

	@Override
	public void register(Enterprise enterprise) {
		// TODO Auto-generated method stub
		if(checkIfExist(enterprise.getEnterpriseAccount())){
			enterpriseDAO.insert(enterprise);
			msg="注册成功!";
		}else{
			msg="注册失败！";
		}

	}
	
	public boolean checkIfExist(String enterpriseAccount){
		if(enterpriseDAO.getEnterpriseByAccount(enterpriseAccount)==null){
			
			msg="true";
			return true;
		}else{
			msg="false";
			return false;
		}
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}

}
