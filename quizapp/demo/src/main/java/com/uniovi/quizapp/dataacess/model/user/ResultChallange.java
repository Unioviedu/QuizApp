package com.uniovi.quizapp.dataacess.model.user;

import com.uniovi.quizapp.dataacess.model.challange.Challange;

public class ResultChallange {
	
	private Challange challange;
	private boolean isComplete;
	
	public ResultChallange() {}
	
	public ResultChallange (Challange challange) {
		this.setChallange(challange);
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Challange getChallange() {
		return challange;
	}

	public void setChallange(Challange challange) {
		this.challange = challange;
	}
	
	

}
