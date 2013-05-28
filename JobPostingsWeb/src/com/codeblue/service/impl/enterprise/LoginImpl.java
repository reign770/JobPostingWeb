package com.codeblue.service.impl.enterprise;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;


import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.service.enterprise.Login;

@Service("ent_login")
public class LoginImpl implements Login {
	private String msg;
	@Resource(name="enterpriseDAO")
	private EnterpriseDAO enterpriseDAO;

	@Override
	public void login(Enterprise enterprise) {
		// TODO Auto-generated method stub
		Enterprise enterprise2=enterpriseDAO.getEnterpriseByAccount(enterprise.getEnterpriseAccount());
		if(enterprise!=null&&enterprise.getPassword().equals(enterprise2.getPassword())){
			//设置名字
			enterprise.setEnterpriseName(enterprise2.getEnterpriseName());
			enterprise.setEnterpriseId(enterprise2.getEnterpriseId());
			enterprise.setLogo(enterprise2.getLogo());
			msg="登录成功";
		}else{
			msg="登录失败";
		}
		

	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}

}
