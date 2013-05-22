package com.codeblue.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.StudentDAO;
import com.codeblue.model.Student;
import com.codeblue.model.property.StudentAccount;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Student student) {
		hibernateTemplate.save(student);
	}

	@Override
	public void update(Student student) {
		hibernateTemplate.update(student);
	}

	@Override
	public void delete(String studentId) {
		Student student = new Student();
		student.setStudentId(studentId);
		hibernateTemplate.delete(studentId);
	}

	@Override
	public Student getByStudentId(String studentId) {
		return (Student) hibernateTemplate.get(Student.class, studentId);
	}

	@Override
	public List<Student> queryByJobIntention(int industryId, int offset,
			int pageSize) {
		DetachedCriteria detachedCriteria = 
				DetachedCriteria.forClass(Student.class,"s")
                .createAlias("s.jobIntention", "j")
                .add(Restrictions.eq("s.state", StudentAccount.UNGRADUATED))
                .add(Restrictions.eq("j.industryId", industryId))
                .addOrder(Order.desc("s.gpa"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByJobIntention(int industryId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
            .createAlias("s.jobIntention", "j")
            .setProjection(Projections.rowCount())
            .add(Restrictions.eq("s.state", StudentAccount.UNGRADUATED))
			.add(Restrictions.eq("j.industryId", industryId));
	return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public List<Student> queryByDepartment(int departmentId, int offset,
			int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.createAlias("s.schoolClass", "c")
				.createAlias("c.major", "m")
				.createAlias("m.department", "d")
				.add(Restrictions.eq("d.departmentId", departmentId))
				.addOrder(Order.desc("c.grade"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByDepartment(int departmentId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.setProjection(Projections.rowCount())
				.createAlias("s.schoolClass", "c")
				.createAlias("c.major", "m")
				.createAlias("m.department", "d")
				.add(Restrictions.eq("d.departmentId", departmentId));
			return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public List<Student> queryByMajor(int majorId, int offset, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.createAlias("s.schoolClass", "c")
				.createAlias("c.major", "m")
				.add(Restrictions.eq("m.majorId", majorId))
				.addOrder(Order.desc("c.grade"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByMajor(int majorId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.setProjection(Projections.rowCount())
				.createAlias("s.schoolClass", "c")
				.createAlias("c.major", "m")
				.add(Restrictions.eq("m.majorId", majorId));
		return (long)hibernateTemplate.findByCriteria(detachedCriteria).get(0);	
	}

	@Override
	public List<Student> queryByClass(int classId, int offset, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.createAlias("s.schoolClass", "c")
				.add(Restrictions.eq("c.classId", classId))
				.addOrder(Order.desc("c.grade"));
		return hibernateTemplate.findByCriteria(detachedCriteria,offset,pageSize);
	}

	@Override
	public long getCountByClass(int classId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class,"s")
				.setProjection(Projections.rowCount())
				.createAlias("s.schoolClass", "c")
				.add(Restrictions.eq("c.classId", classId));
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
