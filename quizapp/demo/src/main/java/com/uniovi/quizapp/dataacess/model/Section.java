package com.uniovi.quizapp.dataacess.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;

import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

public class Section extends DefaultEntity {
	
	private String codSection;
	private String title;
	private String description;
	private int experience;
	
	private List<String> nextSections = new ArrayList<>();
	
	@Embedded
	private Set<Level> levels = new HashSet<>();
	
	public Section() {}
	
	public Section(String codSection, String title, String description) {
		super();
		this.codSection = codSection;
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<Level> getLevels() {
		return levels;
	}
	
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}
	
	public String getCodSection() {
		return codSection;
	}
	
	public void setCodSection(String codSection) {
		this.codSection = codSection;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addLevels(Level...levels) {
		for (int i = 0; i < levels.length; i++) {
			Level level = levels[i];
			if (i == 0)
				level.setFirst(true);
			level.setCodSection(codSection);
			this.levels.add(level);
		}
		
	}

	public List<String> getNextSections() {
		return nextSections;
	}

	public void setNextSections(List<String> nextSections) {
		this.nextSections = nextSections;
	}
	
	public void addNextSection(Section section) {
		this.nextSections.add(section.getCodSection());
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	

}
