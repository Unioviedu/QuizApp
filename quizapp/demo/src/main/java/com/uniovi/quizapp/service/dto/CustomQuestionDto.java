package com.uniovi.quizapp.service.dto;

import com.uniovi.quizapp.dataacess.model.question.Question;

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
