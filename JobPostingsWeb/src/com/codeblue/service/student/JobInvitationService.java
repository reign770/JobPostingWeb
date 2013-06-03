package com.codeblue.service.student;

import com.codeblue.util.PageBean;

public interface JobInvitationService {
	
	public PageBean getIngoredJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getAcceptedJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getAllJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getUnProcessInvitations(String studentId,int pageNumber,int pageSize);
	/**
	 * 接受邀请
	 * @param invitationId
	 * @param content
	 * @return 0. 接受失败 1.接受失败
	 */
	public int acceptJobInvitation(long invitationId,String content);
	
	public int ingoreJobInvitation(long invitationId);	

}
