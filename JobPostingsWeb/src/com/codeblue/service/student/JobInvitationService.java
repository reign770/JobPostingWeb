package com.codeblue.service.student;

import com.codeblue.util.PageBean;

public interface JobInvitationService {
	
	public PageBean getIngoredJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getAcceptedJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getAllJobInvitations(String studentId,int pageNumber,int pageSize);
	
	public PageBean getUnProcessInvitations(String studentId,int pageNumber,int pageSize);
	
	public int acceptJobInvitation(long invitationId);
	
	public int ingoreJobInvitation(long invitationId);	

}
