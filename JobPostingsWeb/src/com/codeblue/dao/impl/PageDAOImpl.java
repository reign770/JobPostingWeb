package com.codeblue.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.codeblue.dao.PageDAO;

public class PageDAOImpl implements PageDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List queryForPage(final String hql, final Object[] values, final int offset,
			final int pageSize) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					for(int i = 0 ;i < values.length; i++){
						query.setParameter(i, values[i]);
					}
				}
				
				return query.setFirstResult(offset)
					   .setMaxResults(pageSize)
					   .list();
			}
		});
	}

	@Override
	public int getAllRowCount(final String hql) {
		
		return (int) hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				return session.createQuery(hql).uniqueResult();
			}
		});
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
