package com.uniovi.quizapp.dataacess.model.user;

import java.util.HashMap;
import java.util.Map;

import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

public class User extends DefaultEntity {
	
	private String username;
	private String password;
	private Map<String, ResultSection> resultSections = new HashMap<>();
	
	public User() {}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	
}
