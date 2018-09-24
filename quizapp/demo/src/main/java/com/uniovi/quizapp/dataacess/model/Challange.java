package com.uniovi.quizapp.dataacess.model;

import org.mongodb.morphia.annotations.Entity;

import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

@Entity
public class Challange extends DefaultEntity {
	
	private int codChallange;
	private String description;

	public Challange() {}
	
	public Challange(int codChallange, String description) {
		super();
		this.codChallange = codChallange;
		this.description = description;
	}

	public int getCodChallange() {
		return codChallange;
	}

	public void setCodChallange(int codChallange) {
		this.codChallange = codChallange;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
