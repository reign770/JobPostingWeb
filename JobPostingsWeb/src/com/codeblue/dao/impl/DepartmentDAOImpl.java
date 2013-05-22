package com.codeblue.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.codeblue.dao.DepartmentDAO;
import com.codeblue.model.Department;

@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO{
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insert(Department department) {
		hibernateTemplate.save(department);
	}

	@Override
	public void update(Department department) {
		hibernateTemplate.update(department);
	}

	@Override
	public void delete(int departmentId) {
		Department department = new Department();
		department.setDepartmentId(departmentId);
		hibernateTemplate.delete(department);
	}

	@Override
	public Department getByDepartmentId(int departmentId) {
		return (Department)hibernateTemplate.get(Department.class, departmentId);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	

}
