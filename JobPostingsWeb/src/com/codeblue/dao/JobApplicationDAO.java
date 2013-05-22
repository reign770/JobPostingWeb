package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.JobApplication;

public interface JobApplicationDAO {
	/**
	 * 获取求职信息
	 * @param applyId
	 * @return
	 */
	public JobApplication getByJobApplicationId(Long applyId);
	
	/**
	 * 获取求职信息
	 * @param studentId
	 * @param recruitmentId
	 * @return
	 */
	public JobApplication getByJobApplicationFK(String studentId,int recruitmentId);
	/**
	 * 插入一条求职信息
	 * @param jobApplication
	 */
	public void insert(JobApplication jobApplication);
	/**
	 * 更新一条求职信息
	 * @param jobApplication
	 */
	public void update(JobApplication jobApplication);
	/**
	 * 删除一条求职信息
	 * @param applyId
	 */
	public void delete(Long applyId);
	/**
	 * 根据学生编号获取职位申请信息
	 * @param studentId
	 * @param states 状态集
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<JobApplication> queryByStudentId(String studentId,Integer[] states,int offset,int pageSize);
	/**
	 * 根据学生编号获取学生职位申请的总数
	 * @param studentId
	 * @param states 状态集
	 * @return
	 */
	public long getCountByStudentId(String studentId,Integer[] states);
	/**
	 * 根据企业编号获取职位申请的信息
	 * @param enterpriseId
	 * @param states
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<JobApplication> queryByEnterpriseId(int enterpriseId,Integer[] states,int offset,int pageSize);
	/**
	 * 根据企业编号获取职位申请的总数
	 * @param enterpriseId
	 * @param states
	 * @return
	 */
	public long getCountByEnterpriseId(int enterpriseId,Integer[] states);
	/**
	 * 根据招聘信息的编号获取职位申请的信息
	 * @param recruitmentId
	 * @param states
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<JobApplication> queryByRecruitmentId(int recruitmentId,Integer[] states,int offset,int pageSize);
	/**
	 * 根据招聘信息获取职位申请信息的总数
	 * @param recruitmentId
	 * @param states
	 * @return
	 */
	public long getCountByRecruitmentId(int recruitmentId,Integer[] states);
	
	
	
}
