package com.codeblue.dao;

import java.util.List;


public interface PageDAO {
	
	/**
	 * 分页查询
	 * @param hql 需要查询的hql语句
	 * @param values 传入hql语句的参数
	 * @param offset 第一条记录索引
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List queryForPage(final String hql,final Object[] values,final int offset,final int pageSize);
	/**
	 * 根据查询语句返回查询总数
	 * @param hql 需要查询的hql语句
	 * @return
	 */
	public int getAllRowCount(final String hql);

}
