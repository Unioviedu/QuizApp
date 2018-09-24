package com.uniovi.quizapp.logic.api;

import java.util.List;

import com.uniovi.quizapp.service.dto.section.SectionDto;
import com.uniovi.quizapp.service.dto.section.ShortSectionDto;

public interface ISectionManagement {
	
	public SectionDto getSectionByCod(String cod, String username);
	
	public List<ShortSectionDto> getSectionList(String username);

}
