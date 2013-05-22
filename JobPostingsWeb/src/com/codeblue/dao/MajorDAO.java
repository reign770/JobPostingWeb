package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.Major;

public interface MajorDAO {
	/**
	 * 插入一个专业
	 * @param major
	 */
	public void insert(Major major);
	/**
	 * 跟心一个专业
	 * @param major
	 */
	public void update(Major major);
	/**
	 * 根据专业编号删除一个专业
	 * @param majorId
	 */
	public void delete(int majorId);
	/**
	 * 根据专业编号获取专业的信息
	 * @param majorId
	 * @return
	 */
	public Major getByMajorId(int majorId);
	/**
	 * 查询一个学院的下的所有专业
	 * @param departmentId
	 * @return
	 */
	public List<Major> queryByDepartmentId(int departmentId);

}
