package com.uniovi.quizapp.dataacess.model.challange;

import org.mongodb.morphia.annotations.Entity;

import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

@Entity("Challange")
public abstract class Challange extends DefaultEntity {
	
	private int codChallange;
	private String description;
	private int experience;
	protected ChallangeType challageType;

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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public ChallangeType getChallangeType() {
		return challageType;
	}

	public void setChallangeType(ChallangeType type) {
		this.challageType = type;
	}
	
	
	
	

}
