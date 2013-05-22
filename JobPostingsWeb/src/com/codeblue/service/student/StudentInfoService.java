package com.codeblue.service.student;

import java.util.List;

import com.codeblue.model.Brief;
import com.codeblue.model.JobInvitation;
import com.codeblue.model.Student;
import com.codeblue.util.PageBean;

/**
 * 
 * @author 李佳奇
 * @datetime 2013-5-20 下午10:42:08
 */
public interface StudentInfoService {
	
	public int validLogin(String studentId,String password);
	
	public int modifyBrief(Brief brief);
	
	public Student getResume(String studentId);

}
