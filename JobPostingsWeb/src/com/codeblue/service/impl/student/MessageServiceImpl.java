package com.codeblue.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.NotificationDAO;
import com.codeblue.model.Notification;
import com.codeblue.model.property.NotificationState;
import com.codeblue.service.student.MessageService;
import com.codeblue.util.PageBean;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
	
	private NotificationDAO notificationDAO;
	
	@Override
	public PageBean getAllNotifications(String studentId, int pageNumber,
			int pageSize) {
		List<Notification> list = notificationDAO.queryByStudentId(studentId, 
								  NotificationState.ALL, (pageNumber-1)*pageSize, 
								  pageSize);
		long allRow = notificationDAO.getCountByStudentId(studentId, NotificationState.ALL);
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();
		return pageBean;
	}

	@Override
	public PageBean getUnreadedNotifications(String studentId, int pageNumber,
			int pageSize) {
		List<Notification> list = notificationDAO.queryByStudentId(studentId, 
												  new Integer[]{NotificationState.UNREAD}, 
												  (pageNumber-1)*pageSize, 
												  pageSize);
		long allRow = notificationDAO.getCountByStudentId(studentId, 
									new Integer[]{NotificationState.UNREAD});
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();
		return pageBean;	
	}

	@Override
	public PageBean getReadedNotifications(String studentId, int pageNumber,
			int pageSize) {
		List<Notification> list = notificationDAO.queryByStudentId(studentId, 
						  new Integer[]{NotificationState.READED}, 
						  (pageNumber-1)*pageSize, 
						  pageSize);
		long allRow = notificationDAO.getCountByStudentId(studentId, 
			               new Integer[]{NotificationState.READED});
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(pageNumber);
		pageBean.setPageSize(pageSize);
		pageBean.init();
		return pageBean;		
	}


	@Override
	public int deleteNotification(long notificationId) {
		notificationDAO.delete(notificationId);
		return 0;
	}

	@Override
	public Notification readNotification(long notificationId) {
		Notification notification = notificationDAO
				.getByNotificationId(notificationId);
		if(notification.getState() == NotificationState.UNREAD) {
			notification.setState(NotificationState.READED);
			notificationDAO.update(notification);
		}
		return notification;
	}

	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}
	
	@Resource
	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}


	

}
