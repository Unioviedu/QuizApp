package com.uniovi.quizapp.service.dto.level;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultLevelDto {
	
	private String idSection;
	private String idLevel;
	
	private String username;
	private int numCorrectQuestion;
	private int numIncorrectQuestion;
	private int expBase;
	
	private List<String> nextLevels = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getExpBase() {
		return expBase;
	}
	public void setExpBase(int expBase) {
		this.expBase = expBase;
	}
	public ObjectId getIdSection() {
		return new ObjectId(idSection);
	}
	public void setIdSection(String idSection) {
		this.idSection = idSection;
	}
	public ObjectId getIdLevel() {
		return new ObjectId(idLevel);
	}
	public void setIdLevel(String idLevel) {
		this.idLevel = idLevel;
	}
	
	
		
	
	

}
