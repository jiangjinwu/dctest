package com.dc.function.paper.model;

import java.io.Serializable;

public class Option implements Serializable {

	String optionId;
	String optionName;
	String questionId;
	String nextOptionId;
	
	public  Option() {
		super();
		
	}
	
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getNextOptionId() {
		return nextOptionId;
	}
	public void setNextOptionId(String nextOptionId) {
		this.nextOptionId = nextOptionId;
	}
	
	
	
}
