package com.codeblue.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.EnterpriseDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Student;
import com.codeblue.model.property.EnterpriseAccountState;
import com.codeblue.model.property.StudentAccount;

@Repository("enterpriseDAO")
public class EnterpriseDAOImpl implements EnterpriseDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Enterprise getEnterpriseByAccount(final String account) {
		return (Enterprise)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from Enterprise e where e.enterpriseAccount=?");
				query.setString(0, account);
				
				return query.uniqueResult();
			}
		});
	}

	@Override
	public void insert(Enterprise enterprise) {
		hibernateTemplate.save(enterprise);
	}

	@Override
	public void update(Enterprise enterprise) {
		hibernateTemplate.update(enterprise);
	}

	@Override
	public void delete(int enterpriseId) {
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(enterpriseId);
		hibernateTemplate.delete(enterprise);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enterprise> queryByStudentConcern(final String studentId, final int offset,
			final int pageSize) {
		
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from Student s where s.studentId = :studentId ");
				query.setString("studentId", studentId);
				Student student = (Student)query.uniqueResult(); 
				return session.createFilter(student.getConcernEnterprises(),
						"where this.state = "+EnterpriseAccountState.PASS )
						.setFirstResult(offset).setMaxResults(pageSize).list();
			}
		});
	}

	@Override
	public long getCountByStudentConcern(final String studentId) {
		return ((BigInteger)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery query = 
				session.createSQLQuery("select count(*) " +
						"from concernEnterprise c ,Enterprise e where c.studentId = :studentId " +
						"and e.state = :state " +
						"and c.enterpriseId = e.enterpriseId");
				query.setString("studentId", studentId);
				query.setInteger("state", EnterpriseAccountState.PASS);
				return query.uniqueResult(); 
			}
		})).longValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enterprise> queryByAddition(final String queryWord, final String address,
			final String property, final int offset, final int pageSize) {
		
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = session.createCriteria(Enterprise.class);
				Map valueMap = new HashedMap();
				valueMap.put("state", EnterpriseAccountState.PASS);
				if(address != null)
					valueMap.put("address", address);
				if(property != null)
					valueMap.put("enterpriseProperty", property);
				criteria.add(Restrictions.allEq(valueMap));
				if(queryWord != null)
				    criteria.add(Restrictions.like("enterpriseName", queryWord,MatchMode.ANYWHERE));
				criteria.setFirstResult(offset);
				criteria.setMaxResults(pageSize);
				return criteria.list();
			}
		});
	}

	@Override
	public long getCountByAddition(final String queryWord, final String address,
			final String property) {
		return (int)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = session.createCriteria(Enterprise.class);
				Map valueMap = new HashedMap();
				valueMap.put("state", EnterpriseAccountState.PASS);
				if(address != null)
					valueMap.put("address", address);
				if(property != null)
					valueMap.put("enterpriseProperty", property);
				criteria.add(Restrictions.allEq(valueMap));
				if(queryWord != null)
				criteria.add(Restrictions.like("enterpriseName", queryWord,MatchMode.ANYWHERE));
				return criteria.list().size();
			}
		});
	}
	
	@Override
	public Enterprise getByEnterpriseId(int enterpriseId) {
		return (Enterprise) hibernateTemplate.get(Enterprise.class, enterpriseId);
	}

	@Override
	public List<Enterprise> queryAll(Integer[] states, int offset, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Enterprise.class);
		detachedCriteria.add(Restrictions.in("state", states));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCount(Integer[] states) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Enterprise.class);
		
		detachedCriteria.setProjection(Projections.rowCount())
		.add(Restrictions.in("state", states));
		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
