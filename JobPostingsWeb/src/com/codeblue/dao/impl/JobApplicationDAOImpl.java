package com.codeblue.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sun.font.CreatedFontTracker;

import com.codeblue.dao.JobApplicationDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.JobApplication;
import com.codeblue.model.Recruitment;
import com.codeblue.model.Student;
import com.sun.istack.internal.FinalArrayList;

@Repository("jobApplicationDAO")
public class JobApplicationDAOImpl implements JobApplicationDAO{
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public JobApplication getByJobApplicationId(Long applyId) {
		
		return (JobApplication) hibernateTemplate.get(JobApplication.class, applyId);
	}
	

	@Override
	public JobApplication getByJobApplicationFK(String studentId,
			int recruitmentId) {
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(JobApplication.class);
		Property stuId = Property.forName("student.studentId");
		Property recId = Property.forName("recruitment.recruitmentId");
		detachedCriteria.add(stuId.eq(studentId))
						.add(recId.eq(recruitmentId));
		List list =hibernateTemplate.findByCriteria(detachedCriteria);
		if(list == null||list.size()==0){
			return null;
		}
		else {
			return (JobApplication)list.get(0);
		}
	}



	@Override
	public void insert(JobApplication jobApplication) {
		
		hibernateTemplate.save(jobApplication);
	}

	@Override
	public void update(JobApplication jobApplication) {
		System.out.println(jobApplication.getState()+"   "+jobApplication.getApplyId()+"fffff");
		hibernateTemplate.update(jobApplication);
	}

	@Override
	public void delete(Long applyId) {
		JobApplication jobApplication = new JobApplication();
		jobApplication.setApplyId(applyId);
		hibernateTemplate.delete(jobApplication);
	}


	@Override
	public List<JobApplication> queryByStudentId(String studentId,
			Integer[] states, int offset, int pageSize) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(JobApplication.class) ;
		Map valueMap =new  HashedMap();
		valueMap.put("student.studentId", studentId);
		detachedCriteria.add(Restrictions.allEq(valueMap));
		detachedCriteria.add(Restrictions.in("state", states));
		detachedCriteria.addOrder(Order.desc("applyDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);
	}

	@Override
	public long getCountByStudentId(final String studentId, final Integer[] states) {
		
/*		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(JobApplication.class) ;
		Map valueMap =new  HashedMap();
		valueMap.put("student.studentId", studentId);
		detachedCriteria.add(Restrictions.allEq(valueMap));
		detachedCriteria.add(Restrictions.in("state", states));
		detachedCriteria.addOrder(Order.desc("applyDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria).size();*/
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer("select count(*) from JobApplication j where j.student.studentId = :studentId ");
				stringBuffer.append("and state in(");
				for(int i = 0 ; i<states.length;i++){
					stringBuffer.append(states[i]);
					if(i != states.length -1){
						stringBuffer.append(",");
					}
					else {
						stringBuffer.append(")");
					}
				}
				Query query = session.createQuery(stringBuffer.toString());
				query.setString("studentId", studentId);
				return query.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobApplication> queryByEnterpriseId(final int enterpriseId,
			final Integer[] states, final int offset,final int pageSize) {
/*		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(JobApplication.class);
		Property property = Property.forName("recruitment.enterprise");
		Map valueMap =new  HashedMap();
		valueMap.put("recruitment.enterprise.enterpriseId", enterpriseId);
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseId(enterpriseId);
//		detachedCriteria.add(Restrictions.allEq(valueMap));
		detachedCriteria.add(property.eq(enterprise));
		detachedCriteria.add(Restrictions.in("state", states));
		detachedCriteria.addOrder(Order.desc("applyDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);*/
		return hibernateTemplate.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer("from JobApplication j where j.recruitment.enterprise.enterpriseId = :enterpriseId ");
				stringBuffer.append("and state in(");
				for(int i = 0 ; i<states.length;i++){
					stringBuffer.append(states[i]);
					if(i != states.length -1){
						stringBuffer.append(",");
					}
					else {
						stringBuffer.append(")");
					}
				}
				stringBuffer.append(" order by applyDate desc");
				Query query = session.createQuery(stringBuffer.toString());
				query.setInteger("enterpriseId", enterpriseId);
				return query.setFirstResult(offset).setMaxResults(pageSize).list();
			}
		});
	}

	@Override
	public long getCountByEnterpriseId(final int enterpriseId, final Integer[] states) {
		return (long)hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = 
				new StringBuffer("select count(*) from JobApplication j ");
				stringBuffer.append(" where j.recruitment.enterprise.enterpriseId = :enterpriseId ")
				.append("and state in(");
				for(int i = 0 ; i<states.length;i++){
					stringBuffer.append(states[i]);
					if(i != states.length -1){
						stringBuffer.append(",");
					}
					else {
						stringBuffer.append(")");
					}
				}
				Query query = session.createQuery(stringBuffer.toString());
				query.setInteger("enterpriseId", enterpriseId);
				return query.uniqueResult();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobApplication> queryByRecruitmentId(int recruitmentId,
			Integer[] states, int offset, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(JobApplication.class);
		Property r = Property.forName("recruitment.recruitmentId");
		detachedCriteria.add(r.eq(recruitmentId));
		detachedCriteria.add(Restrictions.in("state", states));
		detachedCriteria.addOrder(Order.desc("applyDate"));
		return hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);
	}

	@Override
	public long getCountByRecruitmentId(int recruitmentId, Integer[] states) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(JobApplication.class);
		Property r = Property.forName("recruitment.recruitmentId");
		detachedCriteria.add(r.eq(recruitmentId))
						.add(Restrictions.in("state", states));
		detachedCriteria.setProjection(Projections.projectionList()
				.add(Projections.rowCount()));
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
