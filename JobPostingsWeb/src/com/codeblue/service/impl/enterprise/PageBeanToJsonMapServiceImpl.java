package com.codeblue.service.impl.enterprise;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codeblue.model.JobApplication;
import com.codeblue.service.enterprise.PageBeanToJsonMapService;
import com.codeblue.util.PageBean;

@Service("ent_PageBeanToJsonMapService")
public class PageBeanToJsonMapServiceImpl implements PageBeanToJsonMapService {

	/* 
	 * 将pagebean中提取所需属性 然后由struts转换为json
	 * DealwithApplicationaTwoAction使用的
	 * @see com.codeblue.service.enterprise.PageBeanToJsonMapService#convertOfDWATA(com.codeblue.util.PageBean)
	 */
	@Override
	public Map convertOfDWATA(PageBean pageBean) {
		// TODO Auto-generated method stub
		Map<String,Object> jsonMap=new HashMap<>();
		
		jsonMap.put("total", pageBean.getAllRow());
		List<JobApplication> jobApplications=pageBean.getList();
		List<Map> tempList=new ArrayList<>();
		int i=1;
		for (JobApplication jobApplication :jobApplications ) {
			
			Map<String, Object> tempMap=new HashMap<>();
			tempMap.put("rowindex",i);
			i++;
			tempMap.put("applyDate",dateConvert(jobApplication.getApplyDate()));
			tempMap.put("postingName",jobApplication.getRecruitment().getPostingName());
			String stateString="";
			switch (jobApplication.getState()) {
			case 0:
				stateString="未处理";
				break;
			case 1:
				stateString="简历筛选通过";
				break;
			case 2:
				stateString="笔试通过";
				break;
			case 3:
				stateString="面试通过";
				break;
			case 4:
				stateString="已签约";
				break;

			default:
				stateString="未处理";
				break;
			}
			tempMap.put("state",stateString);
			tempMap.put("name",jobApplication.getStudent().getName());
			tempMap.put("studentId",jobApplication.getStudent().getStudentId());
	        tempMap.put("sex",jobApplication.getStudent().getSex());
	        tempMap.put("major",jobApplication.getStudent().getSchoolClass().getMajor().getMajorName());
	        tempMap.put("grade",jobApplication.getStudent().getSchoolClass().getGrade());
	        tempMap.put("class",jobApplication.getStudent().getSchoolClass().getClassName());
			tempMap.put("birth",dateConvert(jobApplication.getStudent().getBirthday())); 
	        tempMap.put("nation",jobApplication.getStudent().getNation());
			tempMap.put("eduBackground",jobApplication.getStudent().getDegree());  
	        tempMap.put("gpa",jobApplication.getStudent().getGpa());
	        tempMap.put("content",jobApplication.getContent());
	        tempList.add(tempMap);
		}
		
		jsonMap.put("rows", tempList);
		return jsonMap;
	}
	
	
	/**
	 * 转换日期格式
	 * @param date
	 * @return
	 */
	public String dateConvert (Date date) {
		return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);	
	}

}
