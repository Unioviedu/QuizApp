package com.uniovi.quizapp.dataacess.model.user;

import org.mongodb.morphia.annotations.Entity;

import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

@Entity
public class LevelRank extends DefaultEntity{
	
	private String name;
	private int experience;
	
	public LevelRank() {}
	
	public LevelRank(String name, int experience) {
		super();
		this.name = name;
		this.experience = experience;
	}



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
