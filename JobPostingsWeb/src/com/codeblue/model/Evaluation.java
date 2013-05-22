package com.codeblue.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation {
	private long evaluationId;
	private String content;
	private Date pubdate;//评论时间
	private int enterpriseId;
	private Student student;
	@Id
	@GeneratedValue
	public long getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(long evaluationId) {
		this.evaluationId = evaluationId;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	
	
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	@ManyToOne
	@JoinColumn(name="studentId")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Evaluation [evaluationId=" + evaluationId + ", content="
				+ content + ", pubdate=" + pubdate + ", enterpriseId="
				+ enterpriseId +  "]";
	}
	

}
