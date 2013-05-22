package com.codeblue.service.student;

import com.codeblue.model.Recruitment;
import com.codeblue.util.PageBean;
import com.codeblue.util.QueryAddition;


public interface RecruitmentService {
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
}
