package com.uniovi.quizapp.service.dto.level;

import java.util.ArrayList;
import java.util.List;

public class ResultLevelDto {
	
	private String username;
	private String codSection;
	private String codLevel;
	private int numCorrectQuestion;
	private int numIncorrectQuestion;
	
	private List<String> nextLevels = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCodSection() {
		return codSection;
	}
	public void setCodSection(String codSection) {
		this.codSection = codSection;
	}
	public String getCodLevel() {
		return codLevel;
	}
	public void setCodLevel(String codLevel) {
		this.codLevel = codLevel;
	}
	public int getNumCorrectQuestion() {
		return numCorrectQuestion;
	}
	public void setNumCorrectQuestion(int numCorrectQuestion) {
		this.numCorrectQuestion = numCorrectQuestion;
	}
	public int getNumIncorrectQuestion() {
		return numIncorrectQuestion;
	}
	public void setNumIncorrectQuestion(int numIncorrectQuestion) {
		this.numIncorrectQuestion = numIncorrectQuestion;
	}
	public List<String> getNextLevels() {
		return nextLevels;
	}
	public void setNextLevels(List<String> nextLevels) {
		this.nextLevels = nextLevels;
	}
		
	
	

}
