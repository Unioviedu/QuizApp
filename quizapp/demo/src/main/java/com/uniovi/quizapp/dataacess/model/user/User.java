package com.uniovi.quizapp.dataacess.model.user;

import java.util.HashMap;
import java.util.Map;

import com.uniovi.quizapp.dataacess.model.LevelRank;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

public class User extends DefaultEntity {
	
	private String username;
	private String password;
	
	private int experience;
	private LevelRank levelRank;
	
	private Map<String, ResultTrophy> resultTrophies = new HashMap<>();
	private Map<String, ResultSection> resultSections = new HashMap<>();
	
	public User() {}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void sumExp(int exp) {
		this.experience =+ exp;
	}
	
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
	public Map<String, ResultSection> getResultSections() {
		return resultSections;
	}
	public void setResultSections(Map<String, ResultSection> resultSections) {
		this.resultSections = resultSections;
	}
	
	public void addResultSection (ResultSection rs) {
		resultSections.put(rs.getCodSection(), rs);
	}
	
	public ResultSection getResultSection(String codSection) {
		return resultSections.get(codSection);
	}
	
	public ResultLevel getResultLevel(String codSection, String codLevel) {
		return resultSections.get(codSection).getResultLevels().get(codLevel);
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

	public Map<String, ResultTrophy> getResultTrophies() {
		return resultTrophies;
	}

	public void setResultTrophies(Map<String, ResultTrophy> resultTrophies) {
		this.resultTrophies = resultTrophies;
	}
	
	
	
	
}
