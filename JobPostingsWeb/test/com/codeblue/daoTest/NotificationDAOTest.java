package com.codeblue.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.dao.NotificationDAO;
import com.codeblue.model.Notification;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class NotificationDAOTest extends AbstractJUnit4SpringContextTests{
	
	private NotificationDAO notificationDAO;
	
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByNotificationId() {
		System.out.println(notificationDAO.getByNotificationId(1l));
	}

	@Test
	public void testQueryByStudentId() {
		List<Notification> list = 
				notificationDAO.queryByStudentId("10060130", new Integer[]{0,1,2}, 0, 10);
		for(Notification n: list) {
			System.out.println(n);
		}
	}

	@Test
	public void testGetCountByStudentId() {
		System.out.println(notificationDAO.getCountByStudentId("10060130", new Integer[]{0,1,2}));
	}

	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}
	@Resource
	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}
	
	

}
