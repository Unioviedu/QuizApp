package com.uniovi.quizapp.dataacess.model.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;

import com.uniovi.quizapp.dataacess.model.formattedText.FormattedText;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

public class Section extends DefaultEntity {
	
	private int orden;
	private String title;
	private String description;
	private FormattedText documentation;
	
	private List<String> nextSections = new ArrayList<>();
	
	@Embedded
	private Set<Level> levels = new HashSet<>();
	
	public Section() {}
	
	public Section(String codSection, String title, String description, FormattedText documentation) {
		this.title = title;
		this.documentation = documentation;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addLevels(Level...levels) {
		for (int i = 0; i < levels.length; i++) {
			Level level = levels[i];
			level.setOrden(i+1);
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
		this.nextSections.add(section.getId().toString());
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public FormattedText getDocumentation() {
		return documentation;
	}

	public void setDocumentation(FormattedText documentation) {
		this.documentation = documentation;
	}
	
}
