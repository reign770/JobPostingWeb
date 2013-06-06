package com.codeblue.action.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.codeblue.service.student.MessageService;
import com.codeblue.util.VOUntil;
import com.codeblue.vo.NotificationVO;
import com.codeblue.vo.Status;
import com.opensymphony.xwork2.ActionSupport;

@Controller("app_notificationAction")
public class NotificationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259380873855868073L;
	public static int pageSize = 10;
	//传入参数
	private String studentId;
	private int pageParam;
	private long notificationId;
	//返回数据
	private List<NotificationVO> notificationVOs;
	private Status status = new Status();
	//注入服务
	private MessageService messageService;
	public String getUnreadedNotifications() {
		notificationVOs = VOUntil.convertToNotificationVOs(
				messageService.getUnreadedNotifications(studentId, pageParam, pageSize)
				.getList());
		return "items";
	}
	
	public String getReadedNotifications() {
		notificationVOs = VOUntil.convertToNotificationVOs(
				messageService.getReadedNotifications(studentId, pageParam, pageSize)
				.getList());		
		return "items";
	}
	
	public String readNotification() {
		messageService.readNotification(notificationId);
		status = new Status();
		status.setStatus("succeed");
		return "result";
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getPageParam() {
		return pageParam;
	}
	public void setPageParam(int pageParam) {
		this.pageParam = pageParam;
	}
	public long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<NotificationVO> getNotificationVOs() {
		return notificationVOs;
	}
	public void setNotificationVOs(List<NotificationVO> notificationVOs) {
		this.notificationVOs = notificationVOs;
	}

	public MessageService getMessageService() {
		return messageService;
	}
	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
}
