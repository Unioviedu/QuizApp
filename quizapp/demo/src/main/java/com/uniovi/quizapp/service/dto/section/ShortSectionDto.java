package com.uniovi.quizapp.service.dto.section;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortSectionDto {
	
	private String id;
	private String codSection;
	private String title;
	private String description;
	private boolean isUnlocked;
	private boolean isCompleteAll;
	private List<String> nextSections = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodSection() {
		return codSection;
	}
	public void setCodSection(String codSection) {
		this.codSection = codSection;
	}
	public boolean isUnlocked() {
		return isUnlocked;
	}
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleteAll() {
		return isCompleteAll;
	}
	public void setCompleteAll(boolean isCompleteAll) {
		this.isCompleteAll = isCompleteAll;
	}
	public List<String> getNextSections() {
		return nextSections;
	}
	public void setNextSections(List<String> nextSections) {
		this.nextSections = nextSections;
	}
	
	

}
