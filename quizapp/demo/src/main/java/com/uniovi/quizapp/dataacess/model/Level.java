package com.uniovi.quizapp.dataacess.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;

import com.uniovi.quizapp.dataacess.model.question.Question;

public class Level {
	
	private String codSection;
	private String codLevel;
	private boolean isMain;
	private boolean isFirst;
	private String title;
	private int experience;
	
	private List<String> nextLevels = new ArrayList<>();
	
	@Embedded
	private Set<Question> questions = new HashSet<>();
	
	public Level() {}
	
	public Level(String codLevel, boolean isMain, String title, int experience) {
		super();
		this.codLevel = codLevel;
		this.isMain = isMain;
		this.title = title;
		this.experience = experience;
	}

	public String getName() {
		return title;
	}
	
	public void setName(String name) {
		this.title = name;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	public String getCodLevel() {
		return codLevel;
	}
	
	public void setCodLevel(String codLevel) {
		this.codLevel = codLevel;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
	
	public void addQuestions(Question...questions) {
		for (Question question: questions) 
			this.questions.add(question);
	}

	public List<String> getNextLevels() {
		return nextLevels;
	}

	public void setNextLevels(List<String> nextLevels) {
		this.nextLevels = nextLevels;
	}
	
	public void addNextLevels(Level... levels) {
		for (Level level: levels)
			this.nextLevels.add(level.getCodLevel());
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
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
