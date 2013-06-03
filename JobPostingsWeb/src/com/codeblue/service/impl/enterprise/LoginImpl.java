package com.codeblue.service.impl.enterprise;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;


import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.property.StudentAccount;
import com.codeblue.service.enterprise.Login;

@Service("ent_login")
public class LoginImpl implements Login {
	private int msg;
	@Resource(name="enterpriseDAO")
	private EnterpriseDAO enterpriseDAO;

	@Override
	public void login(Enterprise enterprise) {
		// TODO Auto-generated method stub
		Enterprise enterprise2=enterpriseDAO.getEnterpriseByAccount(enterprise.getEnterpriseAccount());
		if(enterprise2==null){
			msg=2;//用户名不存在
		}else if (enterprise2.getState()==StudentAccount.GRADUATED) {
			msg=4;//已毕业
		}else if(enterprise!=null&&enterprise.getPassword().equals(enterprise2.getPassword())){
			//设置名字
			enterprise.setEnterpriseName(enterprise2.getEnterpriseName());
			enterprise.setEnterpriseId(enterprise2.getEnterpriseId());
			enterprise.setLogo(enterprise2.getLogo());
			msg=1;//登录成功
		}else{
			msg=3;//密码错误
		}
		

	}

	@Override
	public int getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}

}
