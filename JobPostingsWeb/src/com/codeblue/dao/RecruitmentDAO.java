package com.codeblue.dao;

import java.util.List;
import java.util.concurrent.RecursiveAction;

import com.codeblue.model.Recruitment;

public interface RecruitmentDAO {
	/**
	 * 返回一条职位信息
	 * @param recruitmentId
	 * @return
	 */
	public Recruitment getByRecruitmentId(int recruitmentId);
	/**
	 * 插入一条职位信息
	 * @param recruitment
	 */
	public void insert(Recruitment recruitment);
	/**
	 * 更新一条职位信息
	 * @param recruitment
	 */
	public void update(Recruitment recruitment);
	/**
	 * 删除一条职位信息
	 * @param recruitmentId
	 */
	public void delete(int recruitmentId);
	/**
	 * 根据行业的编号获取招聘信息
	 * @param industryId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Recruitment> queryByIndustry(int industryId,int offset,int pageSize);
	/**
	 * 根据行业的编号获取招聘信息的总数
	 * @param industryId
	 * @return
	 */
	public long getCountByIndustry(int industryId);
	/**
	 * 根据企业编号获取招聘信息
	 * @param enterpriseId
	 * @param states
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Recruitment> queryByEnterpriseId(int enterpriseId,Integer[] states,int offset,int pageSize);
	/**
	 * 根据企业编号获取招聘信息的总数
	 * @param enterpriseId
	 * @param states
	 * @return
	 */
	public long getCountByEnterpriseId(int enterpriseId,Integer[] states);
	/**
	 * 根据学生关注的企业获取招聘信息
	 * @param studentId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Recruitment> queryByStudentId(String studentId,int offset,int pageSize);
	/**
	 * 根据学生关注的企业获取招聘信息的总数
	 * @param studentId
	 * @return
	 */
	public long getCountByStudentId(String studentId);
	/**
	 * 根据查询条件（搜索关键字，职位，工作地点，薪水）获取招聘信息 
	 * @param queryWord
	 * @param postingName
	 * @param workingPlace
	 * @param salary
	 * @param enterpriseProperty
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Recruitment> queryByAddition(String queryWord,String postingName,String workingPlace,Integer salary,
			String enterpriseProperty, int offset,int pageSize);
	/**
	 * 获取根据查询条件（搜索关键字，职位，工作地点，薪水）获取招聘信息的总数
	 * @param querWord
	 * @param postingName
	 * @param workingPlace
	 * @param salary
	 * @param enterpriseProperty
	 * @return
	 */
	public long getCountByAddition(String querWord,String postingName,String workingPlace,Integer salary,
			String enterpriseProperty);
	
	
	
}
