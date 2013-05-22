package com.codeblue.model.property;
/**
 * 
 * @author 李佳奇
 * @datetime 2013-4-27 下午2:53:56
 */
public class EnterpriseAccountState {
	/**
	 * 未审核
	 */
	public static final int AUDITING = 0;
	/**
	 * 审核通过
	 */
	public static final int PASS = 1;
	/**
	 * 未审核通过
	 */
	public static final int UNPASS = 2;
	/**
	 * 账号冻结
	 */
	public static final int FREEZE = 3;
	
	public static final Integer[] ALL = {AUDITING,PASS,UNPASS,FREEZE};
}
