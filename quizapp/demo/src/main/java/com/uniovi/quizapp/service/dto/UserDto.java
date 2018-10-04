package com.uniovi.quizapp.service.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uniovi.quizapp.dataacess.model.user.LevelRank;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private String id;
	private String username;
	private String password;
	private int experience;
	private String mail;
	private LevelRank levelRank;
	
	private Set<ResultChallange> resultTrophies = new HashSet<>();
	
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
	public Set<ResultChallange> getResultTrophies() {
		return resultTrophies;
	}
	public void setResultTrophies(Set<ResultChallange> resultTrophies) {
		this.resultTrophies = resultTrophies;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
