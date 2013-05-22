package com.codeblue.service.student;

import com.codeblue.model.Notification;
import com.codeblue.util.PageBean;


/**
 * 
 * @author 李佳奇
 * @datetime 2013-5-21 上午9:41:49
 */
public interface MessageService {
	
	public PageBean getAllNotifications(String studentId, int pageNumber,int pageSize);
	
	public PageBean getUnreadedNotifications(String studentId,int pageNumber,int pageSize);
	
	public PageBean getReadedNotifications(String studentId,int pageNumber,int pageSize);
	
	public PageBean getUnreadedJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public int deleteNotification(long notificationId);
	
	public Notification getNotification(long notificationId);
	
}
