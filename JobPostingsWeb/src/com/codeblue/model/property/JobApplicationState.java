package com.codeblue.model.property;


/**
 * 
 * @author 李佳奇
 * @datetime 2013-4-27 下午2:54:16
 */
public class JobApplicationState {
	/**
	 * 未处理
	 */
	//public final static int UNPROCESS = 0; 
	/**
	 * 学生看到：处理中  企业看到：未处理
	 */
	public final static int PROCESSING = 0; 
	/**
	 * 简历筛选通过
	 */
	public final static int RESUMEPASS = 1; 
	/**
	 * 笔试通过
	 */
	public final static int WRITTEPASS = 2;
	/**
	 * 面试通过
	 */
	public final static int INTERVIEWPASS =3;
	/**
	 * 已签约
	 */
	public final static int SIGNED =4;
	
	/**
	 * 被拒的
	 */
	public final static int REJECTED=5;
	
	
	public final static Integer[] ALL = {PROCESSING,RESUMEPASS,WRITTEPASS,INTERVIEWPASS,SIGNED};
}
