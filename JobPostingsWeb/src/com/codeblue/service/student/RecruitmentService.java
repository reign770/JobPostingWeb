package com.codeblue.service.student;

import java.util.List;

import com.codeblue.model.Industry;
import com.codeblue.model.Recruitment;
import com.codeblue.util.PageBean;
import com.codeblue.util.QueryAddition;


public interface RecruitmentService {
	/**
	 * 获取所有的行业
	 * @return
	 */
	public List<Industry> getAllIndustries();
	/**
	 * 根据条件查询招聘信息
	 * @param queryAddition
	 * @param pageNumber
	 * @param pageSie
	 * @return
	 */
	public PageBean queryRecruitment(QueryAddition queryAddition,int pageNumber,int pageSize);
	/**
	 * 获取招聘信息
	 * @param recruitmentId
	 * @return
	 */
	public Recruitment getRecruitment(int recruitmentId);
	/**
	 * 获取关注企业的招聘信息
	 * @param studentId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean getConcernRecruitments(String studentId,int pageNumber,int pageSize);
	/**
	 * 根据就业意向获取招聘信息
	 * @param studentId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean getJobIntentionRecruitments(String studentId,int pageNumber,int pageSize);
	/**
	 * 获取某个公司的招聘信息
	 * @param studentId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageBean getEnterpriseRecruitments(int enterpriseId,int pageNumber,int pageSize);
	/**
	 * 是已经申请该职位
	 * @param studentId
	 * @param enterpriseId
	 * @return
	 */
	public Boolean isApplyRecruitment(String studentId,int recruitmentId);
	
}
