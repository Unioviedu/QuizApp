package com.uniovi.quizapp.dataacess.model.question;

public class Option {
	
	private String value;
	private boolean isCorrect;
	
	public Option() {}
	
	public Option(String value, boolean isCorrect) {
		super();
		this.value = value;
		this.isCorrect = isCorrect;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	

}
