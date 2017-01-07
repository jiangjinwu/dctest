package com.dc.function.paper.model;

import java.util.List;

public class Question {

	String questionId;
	String questionName;
	String sectionId;
	String paperId;
	int questionScore;
	
	List<Option> options;
	
	Explain explain;
	
	
	public Explain getExplain() {
		return explain;
	}
	public void setExplain(Explain explain) {
		this.explain = explain;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public int getQuestionScore() {
		return questionScore;
	}
	public void setQuestionScore(int questionScore) {
		this.questionScore = questionScore;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	
	
}
