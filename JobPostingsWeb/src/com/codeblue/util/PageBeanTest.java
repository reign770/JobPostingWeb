package com.codeblue.util;

public class PageBeanTest {
	
	public static void testPrint(PageBean pageBean){
		if(pageBean == null) {
			System.out.println("空");
			return ;
		}
		System.out.println("totalpage:"+pageBean.getTotalPage());
		System.out.println("currentPage:"+pageBean.getCurrentPage());
		System.out.println("allRow:"+pageBean.getAllRow());
	    if(pageBean.getList() != null)
		for(Object o: pageBean.getList()) {
			System.out.println(o);
		}
	}

}
