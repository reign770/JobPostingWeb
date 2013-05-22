package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.EmployeementInfo;

public interface EmployeementInfoDAO {
	/**
	 * 根据招聘信息的编号返回一条招聘信息
	 * @param infoId
	 * @return
	 */
	public EmployeementInfo getByInfoId(int infoId);
	/**
	 * 插入一条就业信息
	 * @param employeementInfo
	 */
	public void insert(EmployeementInfo employeementInfo);
	/**
	 * 更新一条就业信息
	 * @param employeementInfo
	 */
	public void update(EmployeementInfo employeementInfo);
	/**
	 * 删除一条就业信息
	 * @param employeementInfo
	 */
	public void delete(int infoId);
	/**
	 * 获取所有就业信息
	 * @param offset
	 * @param pageSize
	 */
	public List<EmployeementInfo> getAll(int offset,int pageSize);
	/**
	 * 获取所有就业信息的总数
	 */
	public long getCount();
	

}
