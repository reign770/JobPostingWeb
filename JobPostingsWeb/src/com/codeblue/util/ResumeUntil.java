package com.codeblue.util;

import com.codeblue.model.Brief;
import com.codeblue.vo.Resume;

public class ResumeUntil {
	
	public static Resume changeToResume(Brief brief) {
		Resume resume = new Resume();
		resume.setStudentId(brief.getStudentId());
		resume.setInterests(brief.getInterests().split(","));
		resume.setHonors(brief.getHonor().split(","));
		resume.setMajorCourse(brief.getMajorCourse().split(","));
	    resume.setExperience(brief.getExperience().split(","));
	    resume.setResume(brief.getResume());
		return resume;
	}
	
	public static Brief changeToBrief(Resume resume){
		Brief brief = new Brief();
		StringBuffer majorCoursesBuffer  = new StringBuffer();
		if(resume.getMajorCourse() != null)
		for(String course:resume.getMajorCourse()) {
			if(course != null && !course.trim().equals(""))
				majorCoursesBuffer.append(course).append(",");
		}
		StringBuffer intrestBuffer = new StringBuffer();
		if(resume.getInterests() != null)
		for(String intrest:resume.getInterests()) {
			if(intrest!=null&&!intrest.trim().equals(""))
				intrestBuffer.append(intrest.trim()).append(",");
		}
		StringBuffer honorBuffer = new StringBuffer();
		if(resume.getHonors() != null)
		for(String honor:resume.getHonors()) {
			if(honor!=null&&!honor.trim().equals("")){
				honorBuffer.append(honor.trim()).append(",");
			}
		}
		
		StringBuffer experienceBuffer = new StringBuffer();
		if(resume.getExperience() != null)
		for(String exper:resume.getHonors()) {
			if(exper != null && !exper.trim().equals("")){
				experienceBuffer.append(exper.trim()).append(",");
			}
		}
		
		brief.setStudentId(resume.getStudentId());
		brief.setMajorCourse(majorCoursesBuffer.toString());
		brief.setExperience(experienceBuffer.toString());
		brief.setHonor(honorBuffer.toString());
		brief.setInterests(intrestBuffer.toString());
		brief.setResume(resume.getResume());
		return brief;
	}

}
