package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.Evaluation;

public interface EvaluationDAO {
	/**
	 * 插入一条新的评论
	 * @param evaluation
	 */
	public void insert(Evaluation evaluation);
	/**
	 * 更新一条评论信息
	 * @param evaluation
	 */
	public void update(Evaluation evaluation);
	/**
	 * 删除一条评论
	 * @param evluationId
	 */
	public void delete(long evaluationId);
	/**
	 * 根据企业的编号获取有关企业的评论
	 * @param enterpriseId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Evaluation> queryByEnterpriseId(int enterpriseId,int offset,int pageSize);
	/**
	 * 根据企业的编号获取有关企业评论的总数
	 * @param enterpriseId
	 * @return
	 */
	public long getCountByEnterpriseId(int enterpriseId);
	/**
	 * 根据学生的编号获取学生所有的评论
	 * @param studentId
	 * @return
	 */
	public List<Evaluation> queryByStudentId(String studentId,int offset,int pageSize);
	/**
	 * 根据学生的编号获取学生所有的评论的总数
	 * @param studentId
	 * @return
	 */
	public long getCountByStudentId(String studentId);

}
