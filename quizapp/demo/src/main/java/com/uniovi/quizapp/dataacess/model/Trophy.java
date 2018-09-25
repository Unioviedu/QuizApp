package com.uniovi.quizapp.dataacess.model;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class Trophy {
	
	private String codTrophy;
	private String description;
	private int experience;
	
	public String getCodTrophy() {
		return codTrophy;
	}
	public void setCodTrophy(String codTrophy) {
		this.codTrophy = codTrophy;
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
	
	

}
