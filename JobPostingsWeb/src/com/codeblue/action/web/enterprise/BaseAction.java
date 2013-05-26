package com.codeblue.action.web.enterprise;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;;

/**
 * @author 周奥特
 * 获取session的基类
 */
public class BaseAction implements SessionAware{
	protected Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
		
	}

}
