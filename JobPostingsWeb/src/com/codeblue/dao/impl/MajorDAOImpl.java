package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.MajorDAO;
import com.codeblue.model.Major;

@Repository("majorDAO")
public class MajorDAOImpl implements MajorDAO{

	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Major major) {
		hibernateTemplate.save(major);
	}

	@Override
	public void update(Major major) {
		hibernateTemplate.update(major);
	}

	@Override
	public void delete(int majorId) {
		Major major = new Major();
		major.setMajorId(majorId);
		hibernateTemplate.delete(major);
	}

	@Override
	public Major getByMajorId(int majorId) {
		return (Major)hibernateTemplate.get(Major.class, majorId);
	}

	@Override
	public List<Major> queryByDepartmentId(int departmentId) {
		Property deId = Property.forName("department.departmentId");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Major.class);
		detachedCriteria.add(deId.eq(departmentId));
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
