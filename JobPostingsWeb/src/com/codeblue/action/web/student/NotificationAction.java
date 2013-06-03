package com.codeblue.action.web.student;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.codeblue.model.Student;
import com.codeblue.service.student.MessageService;
import com.codeblue.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NotificationAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -249189480679356176L;
	private long notificationId;
	private String message;
	private MessageService messageService;
	private Map<String, Object> session;
	private String pageNumber;
	private String pageSize;
	private PageBean pageBean;

	@Override
	public String execute() throws Exception {
		String studentId = 
				((Student)session.get("student")).getStudentId();
 		pageBean = messageService.getUnreadedNotifications(studentId, 
 				Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
		return SUCCESS;
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	//获取未读过的信息
	public String unreaded() {
		String studentId = 
				((Student)session.get("student")).getStudentId();
 		pageBean = messageService.getUnreadedNotifications(studentId, 
 				Integer.valueOf(pageNumber), 
 				Integer.valueOf(pageSize));
		return "item";
	}
	//获取读过的信息
	public String readed() {
		String studentId = 
				((Student)session.get("student")).getStudentId();
 		pageBean = messageService.getReadedNotifications(studentId, 
 				Integer.valueOf(pageNumber), 
 				Integer.valueOf(pageSize));
		return "item";
	}
	
	public String read() {
		messageService.readNotification(notificationId);
		message="readed_success";
		return "readed_success";
		
	}
	@JSON(serialize=false)
	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	@JSON(serialize=false)
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@JSON(serialize=false)
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	@JSON(serialize=false)
	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}
	@JSON(serialize=false)
	public MessageService getMessageService() {
		return messageService;
	}
	@JSON(serialize=true)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	
}
