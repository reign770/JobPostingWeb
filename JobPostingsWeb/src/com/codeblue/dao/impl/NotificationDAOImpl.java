package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.NotificationDAO;
import com.codeblue.model.Notification;
@Repository("notificationDAO")
public class NotificationDAOImpl implements NotificationDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Notification notification) {
		hibernateTemplate.save(notification);
	}

	@Override
	public void update(Notification notification) {
		hibernateTemplate.update(notification);
	}

	@Override
	public void delete(Long notificationId) {
		Notification notification = new Notification();
		notification.setNotificationId(notificationId);
		hibernateTemplate.delete(notificationId);
	}

	@Override
	public Notification getByNotificationId(Long notificationId) {
		
		return (Notification) hibernateTemplate.get(Notification.class, notificationId);
	}

	@Override
	public List<Notification> queryByStudentId(String studentId, Integer[] states,
			int offset, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Notification.class);
		Property stuId = Property.forName("studentId");
		detachedCriteria.add(stuId.eq(studentId))
						.add(Restrictions.in("state", states));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByStudentId(String studentId, Integer[] states) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Notification.class);
		detachedCriteria.setProjection(Projections.rowCount())
						.add(Property.forName("studentId").eq(studentId))
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
