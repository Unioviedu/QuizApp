package com.uniovi.quizapp.dataacess.model.challange;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property ="className", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
	@JsonSubTypes.Type(value = ChallangeSection.class, name = "com.uniovi.quizapp.dataacess.model.challange.ChallangeSection"),
	@JsonSubTypes.Type(value = ChallangeTrophy.class, name = "com.uniovi.quizapp.dataacess.model.challange.ChallangeTrophy")
})
@Entity("Challange")
public abstract class Challange extends DefaultEntity {
	
	private int codChallange;
	private String description;
	private int experience;
	protected ChallangeType challangeType;

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
		return challangeType;
	}

	public void setChallangeType(ChallangeType type) {
		this.challangeType = type;
	}
	
	
	
	

}
