package com.uniovi.quizapp.service.dto.level;

import java.util.ArrayList;
import java.util.List;

public class ResponseLevelDto {
	
	private List<String> levelsUnlock = new ArrayList<>();
	private List<String> sectionsUnlock = new ArrayList<>();
	private List<String> challangesComplete = new ArrayList<>();
	private int newExp;
	
	public List<String> getLevelsUnlock() {
		return levelsUnlock;
	}
	public void setLevelsUnlock(List<String> levelsUnlock) {
		this.levelsUnlock = levelsUnlock;
	}
	public List<String> getSectionsUnlock() {
		return sectionsUnlock;
	}
	public void setSectionsUnlock(List<String> sectionsUnlock) {
		this.sectionsUnlock = sectionsUnlock;
	}
	public int getNewExp() {
		return newExp;
	}
	public void setNewExp(int newExp) {
		this.newExp = newExp;
	}
	public List<String> getChallangesComplete() {
		return challangesComplete;
	}
	public void setChallangesComplete(List<String> challangesComplete) {
		this.challangesComplete = challangesComplete;
	}
	
	public void addLevel(String levelTitle) {
		levelsUnlock.add(levelTitle);
	}
	
	public void addSection(String sectionTitle) {
		sectionsUnlock.add(sectionTitle);
	}
	
	public void addExp(int exp) {
		this.newExp = this.newExp + exp;
	}
	
	public void addChallange(String challangeDescription) {
		challangesComplete.add(challangeDescription);
	}
	
	

}
