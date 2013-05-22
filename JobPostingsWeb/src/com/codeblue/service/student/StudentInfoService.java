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
	/**
	 * 判断登录信息
	 * @param studentId
	 * @param password
	 * @return
	 *       1 身份正确  2用户名不存  3密码错误
	 */
	public int validLogin(String studentId,String password);
	/**
	 * 修改简历
	 * @param brief
	 * @return
	 */
	public int modifyBrief(Brief brief);
	/**
	 * 获取学生信息
	 * @param studentId
	 * @return
	 */
	public Student getStudent(String studentId);
	/**
	 * 修改学生的就业意向
	 * @param studentId
	 * @param industryId
	 */
	public void modifyJobIntention(String studentId,int industryId);

}
