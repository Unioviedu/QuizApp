package com.uniovi.quizapp.service.dto.level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uniovi.quizapp.dataacess.model.question.Question;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelDto {
	private String codSection;
	private String codLevel;
	private String name;
	private boolean isMain;
	private boolean isUnlocked;
	private boolean isComplete;
	private int numAttemps;
	private int numCorrectQuestion;
	private int numIncorrectQuestion;
	private int experience;
	
	private List<String> nextLevels = new ArrayList<>();
	private Set<Question> questions = new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public boolean isMain() {
		return isMain;
	}
	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
	public String getCodLevel() {
		return codLevel;
	}
	public void setCodLevel(String codLevel) {
		this.codLevel = codLevel;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public int getNumAttemps() {
		return numAttemps;
	}
	public void setNumAttemps(int numAttemps) {
		this.numAttemps = numAttemps;
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
	public boolean isUnlocked() {
		return isUnlocked;
	}
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
	public List<String> getNextLevels() {
		return nextLevels;
	}
	public void setNextLevels(List<String> nextLevels) {
		this.nextLevels = nextLevels;
	}
	public String getCodSection() {
		return codSection;
	}
	public void setCodSection(String codSection) {
		this.codSection = codSection;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	
	

}
