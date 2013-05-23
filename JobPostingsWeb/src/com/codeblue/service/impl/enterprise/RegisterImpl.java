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
		if(enterpriseDAO.getEnterpriseByAccount(enterprise.getEnterpriseAccount())==null){
			enterpriseDAO.insert(enterprise);
			msg="注册成功!";
		}else{
			msg="注册失败！";
		};

	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}

}
