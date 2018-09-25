package com.uniovi.quizapp.dataacess.model;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class LevelRank {
	
	private String name;
	private int experience;
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
