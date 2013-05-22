package com.codeblue.dao;

import com.codeblue.model.Department;

public interface DepartmentDAO {
	
	public void insert(Department department);
	
	public void update(Department department);
	
	public void delete(int departmentId);
	
	public Department getByDepartmentId(int departmentId);

}
