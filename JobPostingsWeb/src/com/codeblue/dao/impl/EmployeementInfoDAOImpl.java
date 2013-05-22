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

import com.codeblue.dao.EmployeementInfoDAO;
import com.codeblue.model.EmployeementInfo;

@Repository("employeementInfoDAO")
public class EmployeementInfoDAOImpl implements EmployeementInfoDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public EmployeementInfo getByInfoId(int infoId) {
		return (EmployeementInfo)hibernateTemplate.get(EmployeementInfo.class, infoId);
	}

	@Override
	public void insert(EmployeementInfo employeementInfo) {
		hibernateTemplate.save(employeementInfo);
	}

	@Override
	public void update(EmployeementInfo employeementInfo) {
		hibernateTemplate.update(employeementInfo);
	}

	@Override
	public void delete(int infoId) {
		EmployeementInfo employeementInfo = new EmployeementInfo();
		employeementInfo.setInfoId(infoId);
		hibernateTemplate.delete(employeementInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeementInfo> getAll(final int offset,final int pageSize) {
		return (List<EmployeementInfo>)hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from EmployeementInfo e");
				return query.setFirstResult(offset).setMaxResults(pageSize).list();
			}
		});
		
	}

	@Override
	public long getCount() {
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("select count(*) from EmployeementInfo e");
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
