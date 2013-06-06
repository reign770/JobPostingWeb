package com.codeblue.vo;

public class EvaluationVO {
	private String evaluationId;//评论编号
	private String studentName;//用户名称
	private String info;//评论内容
	private String pubdate;//发布时间
	public String getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(String evaluationId) {
		this.evaluationId = evaluationId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	@Override
	public String toString() {
		return "EvaluationVO [evaluationId=" + evaluationId + ", studentName="
				+ studentName + ", info=" + info + ", pubdate=" + pubdate + "]";
	}
	
}
