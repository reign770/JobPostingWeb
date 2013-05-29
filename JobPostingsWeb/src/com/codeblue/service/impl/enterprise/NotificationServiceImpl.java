package com.codeblue.service.impl.enterprise;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codeblue.dao.NotificationDAO;
import com.codeblue.model.Enterprise;
import com.codeblue.model.Notification;
import com.codeblue.model.property.NotificationState;
import com.codeblue.service.enterprise.NotificationService;
@Service("ent_notificationService")
public class NotificationServiceImpl implements NotificationService {

	@Resource(name="notificationDAO")
	private NotificationDAO notificationDAO;
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
			content="您已顺利通过简历筛选进入下一阶段,我们会尽快与您取得联系";
			break;
		case 2:
			content="您已顺利通过笔试进入下一阶段,我们会尽快与您取得联系";
			break;
		case 3:
			content="您已顺利通过面试进入下一阶段,我们会尽快与您取得联系";
			break;
		case 4:
			content="您已获得就职机会,我们正在协定签约事宜,并会尽快与您取得联系";
			break;
		case 5:
			content="您未符合本职位要求，敬请关注本公司后续招聘";
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
		notificationDAO.insert(notification);
		
		

	}

}
