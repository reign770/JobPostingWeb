package com.codeblue.dao;

import com.codeblue.model.Brief;

public interface BriefDAO {
	
	public void insert(Brief brief);
	
	public void update(Brief brief);
	
	public void delete(String studentId);
	
	public Brief getByStudentId(String studentId);

}
