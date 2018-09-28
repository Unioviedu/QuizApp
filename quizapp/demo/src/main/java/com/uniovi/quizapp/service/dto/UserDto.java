package com.uniovi.quizapp.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uniovi.quizapp.dataacess.model.LevelRank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private String id;
	private String username;
	private String password;
	private int experience;
	private LevelRank levelRank;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public LevelRank getLevelRank() {
		return levelRank;
	}
	public void setLevelRank(LevelRank levelRank) {
		this.levelRank = levelRank;
	}

}
