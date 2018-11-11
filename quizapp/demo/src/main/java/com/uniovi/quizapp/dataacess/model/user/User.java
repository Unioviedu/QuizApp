package com.uniovi.quizapp.dataacess.model.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;
import com.uniovi.quizapp.dataacess.model.history.Section;

public class User extends DefaultEntity {
	
	private String username;
	private String password;
	private String mail;
	
	private int experience;
	private Rank levelRank;
	
	private Set<ResultChallange> resultTrophies = new HashSet<>();
	private Map<ObjectId, ResultSection> resultSections = new HashMap<>();
	
	public User() {}
	
	public User(String username, String password, String mail, Section firstSection, 
			List<Challange> challanges, List<Challange> trophies,
			Rank firstLevelRank) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		
		this.levelRank = firstLevelRank;
		
		ResultSection rs1 = new ResultSection(firstSection, challanges);
		rs1.setUnlocked(true);
		resultSections.put(rs1.getIdSection(), rs1);
		
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
	
	public void addResultSection (ResultSection rs) {
		resultSections.put(rs.getIdSection(), rs);
	}
	
	public ResultSection getResultSection(ObjectId idSection) {
		return resultSections.get(idSection); 
	}
	
	public ResultLevel getResultLevel(ObjectId idSection, ObjectId idLevel) {
		return getResultSection(idSection)
				.getResultLevels()
				.get(idLevel);
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Rank getLevelRank() {
		return levelRank;
	}

	public void setLevelRank(Rank levelRank) {
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

	public Map<ObjectId, ResultSection> getResultSections() {
		return resultSections;
	}

	public void setResultSections(Map<ObjectId, ResultSection> resultSections) {
		this.resultSections = resultSections;
	}
	
	
}
