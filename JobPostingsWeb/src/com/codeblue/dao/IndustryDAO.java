package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.Industry;

public interface IndustryDAO {
	
	public void insert(Industry industry);
	
	public void update(Industry industry);
	
	public List<Industry> getAllIndustries();

}
