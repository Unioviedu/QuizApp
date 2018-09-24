package com.uniovi.quizapp.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.quizapp.logic.api.ISectionManagement;
import com.uniovi.quizapp.service.api.ISectionController;
import com.uniovi.quizapp.service.dto.section.SectionDto;
import com.uniovi.quizapp.service.dto.section.ShortSectionDto;

@RestController
public class SectionController implements ISectionController {
	
	@Autowired
	private ISectionManagement sectionManagement;
	
	@RequestMapping("/section/{cod}")
	public SectionDto getSection(@PathVariable("cod") String cod,
									  @RequestParam("username") String username) {
		return sectionManagement.getSectionByCod(cod, username);
	}
	
	@RequestMapping("/sections")
	public List<ShortSectionDto> getSectionList(@RequestParam("username") String username) {
		return sectionManagement.getSectionList(username);
	}
}
