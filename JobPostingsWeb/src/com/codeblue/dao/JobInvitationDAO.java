package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.JobInvitation;;

public interface JobInvitationDAO {
	
	/**
	 * 根据邀请编号返回职位邀请信息
	 * @param invitationId
	 * @return
	 */
	public JobInvitation getByInvitationId(long invitationId);
	
	/**
	 * 根据学生编号和招聘信息编号返回职位邀请信息
	 * @param studentId
	 * @param recruitmentId
	 * @return
	 */
	
	public JobInvitation getByJobInvitationFK(String studentId,int recruitmentId);
	/**
	 * 插入一条职位邀请信息
	 * @param jobApplication
	 */
	public void insert(JobInvitation jobInvitation);
	/**
	 * 更新一条职位邀请信息
	 * @param jobApplication
	 */
	public void update(JobInvitation jobInvitation);
	/**
	 * 删除一台职位邀请信息
	 * @param jobInvitationId
	 */
	public void delete(long jobInvitationId);
	/**
	 * 根据学生的编号查询邀请信息
	 * @param studentId
	 * @param states
	 * @param offset
	 * @param pageSize
	 */
	public List<JobInvitation> queryByStudentId(String studentId,Integer[] states,int offset,int pageSize);
	/**
	 * 获取根据学生的编号查询邀请信息的总数
	 * @param studentId
	 * @param states
	 * @return
	 */
	public long getCountByStudentId(String studentId,Integer[] states);
	
	
	
	
}
