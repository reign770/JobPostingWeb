package com.codeblue.dao;

import java.util.List;

import com.codeblue.model.Notification;

public interface NotificationDAO {
	/**
	 * 插入一条通知
	 * @param notification
	 */
	public void insert(Notification notification);
	/**
	 * 更新一条通知
	 * @param notification
	 */
	public void update(Notification notification);
	/**
	 * 删除一条通知
	 * @param notificationId
	 */
	public void delete(Long notificationId);
	/**
	 * 根据通知的编号获取通知信息
	 * @param notificationId
	 * @return
	 */
	public Notification getByNotificationId(Long notificationId);
	/**
	 * 根据学生的编号获取通知信息
	 * @param studentId
	 * @param states
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Notification> queryByStudentId(String studentId,Integer[] states,int offset,int pageSize);
	/**
	 * 获取根据学生的所收到的通知总数
	 * @param studentId
	 * @param states
	 * @return
	 */
	public long getCountByStudentId(String studentId,Integer[] states);

}
