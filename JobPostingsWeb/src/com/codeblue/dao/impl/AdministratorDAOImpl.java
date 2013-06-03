package com.codeblue.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.AdministratorDAO;
import com.codeblue.model.Administrator;
@Repository("administratorDAO")
public class AdministratorDAOImpl implements AdministratorDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Administrator getAdministratorDAO(String account) {
		return (Administrator)hibernateTemplate.get(Administrator.class, account);
	}

	@Override
	public void insert(Administrator administrator) {
		hibernateTemplate.save(administrator);
	}

	@Override
	public void update(Administrator administrator) {
		hibernateTemplate.update(administrator);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
