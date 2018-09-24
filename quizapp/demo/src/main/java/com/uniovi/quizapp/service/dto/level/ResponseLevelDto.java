package com.uniovi.quizapp.service.dto.level;

import java.util.ArrayList;
import java.util.List;

import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;

public class ResponseLevelDto {
	
	private List<ResultLevel> levelsUnlock = new ArrayList<>();
	private List<ResultSection> sectionsUnlock = new ArrayList<>();
	
	public List<ResultLevel> getLevelsUnlock() {
		return levelsUnlock;
	}

	public void setLevelsUnlock(List<ResultLevel> levelsUnlock) {
		this.levelsUnlock = levelsUnlock;
	}

	public void addLevel(ResultLevel level) {
		levelsUnlock.add(level);
	}

	public List<ResultSection> getSectionsUnlock() {
		return sectionsUnlock;
	}

	public void setSectionsUnlock(List<ResultSection> sectionsUnlock) {
		this.sectionsUnlock = sectionsUnlock;
	}
	
	public void addSection(ResultSection rs) {
		sectionsUnlock.add(rs);
	}

}
