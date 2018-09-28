package com.uniovi.quizapp.dataacess.model.challange;

public class ChallangeTrophy extends Challange {
	
	private String title;
	
	public ChallangeTrophy(int codChallange, String description, String title) {
		super(codChallange, description);
		this.challageType = ChallangeType.TROPHY;
		this.title = title;
	}
	
	public ChallangeTrophy() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
