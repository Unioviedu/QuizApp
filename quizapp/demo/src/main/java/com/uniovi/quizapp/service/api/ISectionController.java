package com.uniovi.quizapp.service.api;

import java.util.List;

import com.uniovi.quizapp.service.dto.section.SectionDto;
import com.uniovi.quizapp.service.dto.section.ShortSectionDto;

public interface ISectionController {
	
	public List<ShortSectionDto> getSectionList(String username);
	
	public SectionDto getSection(Integer codSection, String username);

}
