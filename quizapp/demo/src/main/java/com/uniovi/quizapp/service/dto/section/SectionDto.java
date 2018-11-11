package com.uniovi.quizapp.service.dto.section;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uniovi.quizapp.dataacess.model.formattedText.FormattedText;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;
import com.uniovi.quizapp.service.dto.level.LevelDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionDto extends ShortSectionDto {
	
	private FormattedText documentation;
	private Set<LevelDto> levels = new HashSet<>();
	private Set<ResultChallange> challanges = new HashSet<>();
	
	public Set<LevelDto> getLevels() {
		return levels;
	}
	public void setLevels(Set<LevelDto> levels) {
		this.levels = levels;
	}
	public Set<ResultChallange> getChallanges() {
		return challanges;
	}
	public void setChallanges(Set<ResultChallange> challanges) {
		this.challanges = challanges;
	}
	public FormattedText getDocumentation() {
		return documentation;
	}
	public void setDocumentation(FormattedText documentation) {
		this.documentation = documentation;
	}

}
