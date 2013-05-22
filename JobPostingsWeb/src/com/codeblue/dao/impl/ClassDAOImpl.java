package com.codeblue.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.ClassDAO;
import com.codeblue.model.Class;

@Repository("classDAO")
public class ClassDAOImpl implements ClassDAO{
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Class newClass) {
		hibernateTemplate.save(newClass);
	}

	@Override
	public void update(Class newClass) {
		hibernateTemplate.update(newClass);
	}

	@Override
	public void delete(int classId) {
		Class class1 = new Class();
		class1.setClassId(classId);
		hibernateTemplate.delete(class1);
	}
	
	
	

	@Override
	public Class getByClassId(int classId) {
		return (Class)hibernateTemplate.get(Class.class, classId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Class> queryByMajor(final int majorId, final int offset, final int pageSize) {
		List<Class> list = hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query =session.createQuery("from Class c where c.major.majorId = ?");
				query.setParameter(0, majorId);
				query.setFirstResult(offset);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		return list;
	}

	@Override
	public long getCountByMajor(final int majorId) {
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("select count(*) from Class c where c.major.majorId =?");
				query.setParameter(0, majorId);
				return query.uniqueResult();
			}
		});
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
