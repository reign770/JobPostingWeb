package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.JobInvitationDAO;
import com.codeblue.model.JobApplication;
import com.codeblue.model.JobInvitation;

@Repository("jobInvitationDAO")
public class JobInvitationDAOImpl implements JobInvitationDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public JobInvitation getByInvitationId(long invitationId) {
		
		return (JobInvitation)hibernateTemplate.get(JobInvitation.class, invitationId);
	}

	@Override
	public JobInvitation getByJobInvitationFK(String studentId,
			int recruitmentId) {
		
		return null;
	}

	@Override
	public void insert(JobInvitation jobInvitation) {
		hibernateTemplate.save(jobInvitation);
	}

	@Override
	public void update(JobInvitation jobInvitation) {
		hibernateTemplate.update(jobInvitation);
	}

	@Override
	public void delete(long jobInvitationId) {
		JobInvitation jobInvitation = new JobInvitation();
		jobInvitation.setInvitationId(jobInvitationId);
		hibernateTemplate.delete(jobInvitation);
	}

	@Override
	public List<JobInvitation> queryByStudentId(String studentId, Integer[] states, final int offset,
			final int pageSize) {
		Property stuId = Property.forName("student.studentId");
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(JobInvitation.class)
				.add(stuId.eq(studentId))
				.add(Restrictions.in("state", states))
				.addOrder(Order.desc("invitationDate"));
		return (List<JobInvitation>)hibernateTemplate.findByCriteria(detachedCriteria, offset, pageSize);
	}

	@Override
	public long getCountByStudentId(String studentId, Integer[] states) {
		Property stuId = Property.forName("student.studentId");
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(JobInvitation.class)
				.setProjection(Projections.rowCount())
				.add(stuId.eq(studentId))
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
