package com.uniovi.quizapp.dataacess.model.user;

public class ResultLevel {
	
	private String codLevel;
	private boolean isUnlocked;
	private boolean isComplete;
	private boolean isMain;
	private int numAttemps;
	private int numCorrectQuestion;
	private int numIncorrectQuestion;
	
	public ResultLevel() {}
	
	
	public ResultLevel(String codLevel, boolean isComplete, boolean isMain, int numAttemps) {
		this.codLevel = codLevel;
		this.isComplete = isComplete;
		this.setMain(isMain);
		this.numAttemps = numAttemps;
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
	
	

}
