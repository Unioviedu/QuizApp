package com.uniovi.quizapp.dataacess.model.user;

import com.uniovi.quizapp.dataacess.model.Challange;

public class ResultChallange {
	
	private int codChallange;
	private String description;
	private boolean isComplete;
	
	public ResultChallange() {}
	
	public ResultChallange (Challange challange) {
		this.codChallange = challange.getCodChallange();
		this.description = challange.getDescription();
	}
	
	public int getCodChallange() {
		return codChallange;
	}
	public void setCodChallange(int codChallange) {
		this.codChallange = codChallange;
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codChallange;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultChallange other = (ResultChallange) obj;
		if (codChallange != other.codChallange)
			return false;
		return true;
	}
	
	

}
