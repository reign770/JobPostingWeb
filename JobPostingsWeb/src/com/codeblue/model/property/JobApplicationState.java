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
	public final static int UNPROCESS = 0; 
	/**
	 * 处理中
	 */
	public final static int PROCESSING = 1; 
	/**
	 * 笔试通过
	 */
	public final static int WRITTEPASS = 2;
	/**
	 * 面试通过
	 */
	public final static int INTERVIEWPASS =3;
	
	public final static Integer[] ALL = {UNPROCESS,PROCESSING,WRITTEPASS,INTERVIEWPASS};
}
