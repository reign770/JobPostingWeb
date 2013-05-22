package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.IndustryDAO;
import com.codeblue.model.Industry;

@Repository("industryDAO")
public class IndustryDAOImpl implements IndustryDAO{
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Industry industry) {
		hibernateTemplate.save(industry);
		
	}

	@Override
	public void update(Industry industry) {
		hibernateTemplate.save(industry);
	}

	@Override
	public List<Industry> getAllIndustries() {
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(Industry.class);
		return hibernateTemplate.findByCriteria(detachedCriteria);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
