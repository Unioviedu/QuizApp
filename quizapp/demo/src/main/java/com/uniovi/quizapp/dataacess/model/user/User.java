package com.uniovi.quizapp.dataacess.model.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.uniovi.quizapp.dataacess.model.LevelRank;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

public class User extends DefaultEntity {
	
	private String username;
	private String password;
	private String mail;
	
	private int experience;
	private LevelRank levelRank;
	
	private Set<ResultChallange> resultTrophies = new HashSet<>();
	private Map<String, ResultSection> resultSections = new HashMap<>();
	
	public User() {}
	
	public User(String username, String password, String mail, Section firstSection, 
			List<Challange> challanges, List<Challange> trophies,
			LevelRank firstLevelRank) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		
		this.levelRank = firstLevelRank;
		
		ResultSection rs1 = new ResultSection(firstSection, challanges);
		rs1.setUnlocked(true);
		resultSections.put(firstSection.getCodSection(), rs1);
		
		for (Challange trophy: trophies) {
			ResultChallange rc = new ResultChallange(trophy);
			resultTrophies.add(rc);
		}
	}
	
	public void sumExp(int exp) {
		this.experience = this.experience + exp;
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
