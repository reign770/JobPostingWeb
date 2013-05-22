package com.codeblue.modelTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeblue.model.Industry;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class IndustryTest extends AbstractJUnit4SpringContextTests{
	
	HibernateTemplate hibernateTemplate;

	@Test
	public void insertTest(){
		String[] strs = new String[]{"互联网","通信","电子",
				"金融","投资","财会","广告","媒体","出版","艺术",
				"市场","销售","客服","人事","行政","管理","建筑",
				"房产","物业","生产","制造","生物","制药","医疗"};
		for(String jobType:strs){
			Industry industry = new Industry();
			industry.setJobType(jobType);
			hibernateTemplate.save(industry);
		}
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	

}
