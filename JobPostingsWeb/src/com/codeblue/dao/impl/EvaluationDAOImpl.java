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

import com.codeblue.dao.EvaluationDAO;
import com.codeblue.model.Evaluation;

@Repository("evaluationDAO")
public class EvaluationDAOImpl implements EvaluationDAO{
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insert(Evaluation evaluation) {
		hibernateTemplate.save(evaluation);
	}

	@Override
	public void update(Evaluation evaluation) {
		hibernateTemplate.update(evaluation);
	}

	@Override
	public void delete(long evaluationId) {
		Evaluation evaluation = new Evaluation();
		evaluation.setEvaluationId(evaluationId);
		hibernateTemplate.delete(evaluation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluation> queryByEnterpriseId(final int enterpriseId, final int offset,
		   final int pageSize) {
		
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
			    Query query = session.createQuery("from Evaluation e where e.enterpriseId = :enterpriseId");
			    query.setLong("enterpriseId", enterpriseId);
			    query.setFirstResult(offset);
			    query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public  long getCountByEnterpriseId(final int enterpriseId) {
		
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
			    Query query = session.createQuery("select count(*) from Evaluation e where e.enterpriseId = :enterpriseId");
			    query.setInteger("enterpriseId", enterpriseId);
				return query.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluation> queryByStudentId(final String studentId,final int offset,final int pageSize) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from Evaluation e where e.student.studentId = :studentId");
				query.setString("studentId", studentId);
				query.setFirstResult(offset);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public long getCountByStudentId(final String studentId) {
		
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("select count(*) from Evaluation e where e.student.studentId = :studentId");
				query.setString("studentId", studentId);
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
