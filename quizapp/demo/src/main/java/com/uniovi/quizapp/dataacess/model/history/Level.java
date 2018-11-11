package com.uniovi.quizapp.dataacess.model.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.uniovi.quizapp.dataacess.model.question.Question;

public class Level {
	
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	private int orden;
	private boolean isMain;
	private String title;
	private int experience;
	
	private List<String> nextLevels = new ArrayList<>();
	
	@Embedded
	private Set<Question> questions = new HashSet<>();
	
	public Level() {}
	
	public Level(boolean isMain, String title, int experience) {
		this.id = new ObjectId();
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getNextLevels() {
		return nextLevels;
	}

	public void setNextLevels(List<String> nextLevels) {
		this.nextLevels = nextLevels;
	}

	public void addNextLevels(Level... levels) {
		for (Level level: levels)
			this.nextLevels.add(level.getId().toString());
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	public boolean isFirst() {
		return orden == 1;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	

}
