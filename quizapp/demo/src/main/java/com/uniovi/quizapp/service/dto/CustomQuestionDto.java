package com.uniovi.quizapp.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uniovi.quizapp.dataacess.model.question.Question;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomQuestionDto {
	
	private String username;
	private Question question;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
