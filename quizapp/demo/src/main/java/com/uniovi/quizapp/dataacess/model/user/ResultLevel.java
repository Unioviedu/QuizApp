package com.uniovi.quizapp.dataacess.model.user;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.model.history.Level;

public class ResultLevel {
	
	private ObjectId id;
	private String name;
	private boolean isUnlocked;
	private boolean isComplete;
	private boolean isMain;
	private int numAttemps;
	private int numCorrectQuestion;
	private int numIncorrectQuestion;
	
	public ResultLevel() {}
	
	
	public ResultLevel(Level level) {
		this.id = level.getId();
		this.name = level.getName();
		this.isMain = level.isMain();
		this.isUnlocked = level.isFirst();
	}


	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean complete) {
		this.isComplete = complete;
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
	
	public void sumNumAttemps() {
		this.numAttemps++;
	}


	public boolean isUnlocked() {
		return isUnlocked;
	}


	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}


	public boolean isMain() {
		return isMain;
	}


	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
