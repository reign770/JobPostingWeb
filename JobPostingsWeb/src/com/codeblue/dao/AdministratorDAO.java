package com.codeblue.dao;

import com.codeblue.model.Administrator;
/**
 * 
 * @author 李佳奇
 *
 * 2013-4-27
 */
public interface AdministratorDAO {
	/**
	 * 根据账户获取用户信息
	 * @param account
	 * @return
	 */
	public Administrator getAdministratorDAO(String account);
	/**
	 * 插入新的管理员
	 * @param administrator
	 */
	public void insert(Administrator administrator);
	/**
	 * 更新账户信息
	 * @param administrator
	 */
	public void update(Administrator administrator);
	
}
