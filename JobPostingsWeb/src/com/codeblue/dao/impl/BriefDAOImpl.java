package com.codeblue.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.codeblue.dao.BriefDAO;
import com.codeblue.model.Brief;
@Service("briefDAO")
public class BriefDAOImpl implements BriefDAO {
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Brief brief) {
		hibernateTemplate.save(brief);
	}

	@Override
	public void update(Brief brief) {
		hibernateTemplate.update(brief);
	}

	@Override
	public void delete(String studentId) {
		
	}

	@Override
	public Brief getByStudentId(String studentId) {
		return (Brief)hibernateTemplate.get(Brief.class, studentId);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
