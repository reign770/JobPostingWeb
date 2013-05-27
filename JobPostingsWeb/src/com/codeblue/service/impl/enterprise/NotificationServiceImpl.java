package com.codeblue.service.impl.enterprise;

import java.util.Date;

import com.codeblue.model.Enterprise;
import com.codeblue.model.Notification;
import com.codeblue.model.property.NotificationState;
import com.codeblue.service.enterprise.NotificationService;

public class NotificationServiceImpl implements NotificationService {

	/* 
	 * 
	 * 插入一条新通知 通知学生进入第几轮
	 * @see com.codeblue.service.enterprise.NotificationService#saveNotifications(int, java.lang.String, int)
	 */
	@Override
	public void saveNotifications(int enterpriseId,String studentId,int state) {
		// TODO Auto-generated method stub
		
		String content="";
		switch (state) {
		case 1:
			content="您已顺利通过简历筛选进入下一阶段，";
			break;

		default:
			break;
		}
		
		
		
		Enterprise enterprise=new Enterprise();
		Notification notification=new Notification();
		enterprise.setEnterpriseId(enterpriseId);
		notification.setEnterprise(enterprise);
		notification.setPostTime(new Date());
		notification.setState(NotificationState.UNREAD);
		notification.setStudentId(studentId);
		notification.setContent(content);
		

	}

}
