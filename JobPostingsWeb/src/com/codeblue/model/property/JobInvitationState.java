package com.codeblue.model.property;
/**
 * 
 * @author 李佳奇
 * @datetime 2013-4-27 下午2:54:21
 */
public class JobInvitationState {
	/**
	 * 未处理
	 */
	public static final int UNPROCESS = 0;
	/**
	 * 忽略的
	 */
	public static final int INGORE = 1;
	/**
	 * 接受的
	 */
	public static final int ACCEPT = 2;
	
	public static final Integer[] ALL = {UNPROCESS,INGORE,ACCEPT};
	
}
