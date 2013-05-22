package com.codeblue.dao;
import java.util.List;

import com.codeblue.model.Class;

public interface ClassDAO {
	
	public void insert(Class newClass);
	
	public void update(Class newClass);
	
	public void delete(int classId);
	
	public Class getByClassId(int classId);
	
	public List<Class> queryByMajor(int majorId,int offset,int pageSize);
	
	public long getCountByMajor(int majorId);

}
