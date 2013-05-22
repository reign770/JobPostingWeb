package com.codeblue.dao;


import java.util.List;

import com.codeblue.model.Enterprise;

public interface EnterpriseDAO {	
	
	/**
	 * 根据企业编号获取企业
	 * @param enterpriseId
	 * @return
	 */
	public Enterprise getByEnterpriseId(int enterpriseId);
	/**
	 * 根据账户获取某个企业的信息
	 * @param account
	 * @return
	 */
	public Enterprise getEnterpriseByAccount(final String account);
	/**
	 * 新建一个企业
	 * @param enterprise
	 */
	public void insert(Enterprise enterprise);
	/**
	 * 更新一个企业信息
	 * @param enterprise
	 */
	public void update(Enterprise enterprise);
	/**
	 * 删除一个企业
	 * @param account
	 */
	public void delete(int enterpriseId);
	
	/**
	 * 查询学生关注的企业	
	 * @param studentId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> queryByStudentConcern(String studentId,int offset,int pageSize);
	/**
	 * 获取查询学生关注的企业总数
	 * @param studentId
	 * @return
	 */
	public long getCountByStudentConcern(String studentId);
	/**
	 * 根据条件查询企业 
	 * @param querWord
	 * @param address 若为null则为所有地方
	 * @param property 若为null则为全部类型
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> queryByAddition(String queryWord,String address,String property,int offset,int pageSize);
	/**
	 * 获取根据条件查询企业的总数
	 * @param querWord
	 * @param address 若为null则为所有地方
	 * @param property 若为null则为全部类型 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public long getCountByAddition(String queryWord,String address,String property);
	/**
	 * 根据状态获取所有企业
	 * @param states
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> queryAll(Integer[] states,int offset,int pageSize);
	/**
	 * 获取根据状态获取所有企业的总数
	 * @param states
	 * @return
	 */
	public long getCount(Integer[] states);
	
	
	
}
