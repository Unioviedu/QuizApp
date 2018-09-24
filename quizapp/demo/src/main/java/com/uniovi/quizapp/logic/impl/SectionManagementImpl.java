package com.uniovi.quizapp.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.uniovi.quizapp.dataacess.dao.api.ISectionDao;
import com.uniovi.quizapp.dataacess.dao.api.IUserDao;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.api.ISectionManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.service.dto.level.LevelDto;
import com.uniovi.quizapp.service.dto.section.SectionDto;
import com.uniovi.quizapp.service.dto.section.ShortSectionDto;

@Service
public class SectionManagementImpl extends AbstractManagement implements ISectionManagement {

	@Autowired
	private ISectionDao sectionDao;

	@Autowired
	private IUserDao userDao;

	@Override
	public List<ShortSectionDto> getSectionList(String username) {
		List<Section> sections = sectionDao.findAll();
		User user = userDao.findByField("username", username);
		List<ShortSectionDto> sectionsDto = mapper.convertValue(sections, new TypeReference<List<ShortSectionDto>>() {
		});

		for (ShortSectionDto dto : sectionsDto) {
			try {
			ResultSection result = user.getResultSections().get(dto.getCodSection());
			dto.setUnlocked(result.isUnlocked());
			dto.setComplete(result.isComplete());
			} catch (Exception e) {
				dto.setUnlocked(false);
				dto.setComplete(false);
			}
		}

		return sectionsDto;
	}

	@Override
	public SectionDto getSectionByCod(String cod, String username) {
		Section section = sectionDao.findByField("codSection", cod);
		User user = userDao.findByField("username", username);
		SectionDto sectionDto = mapper.convertValue(section, SectionDto.class);
		
		ResultSection rs = user.getResultSections().get(section.getCodSection());
		sectionDto.setChallanges(rs.getResultChallanges());
		
		for (LevelDto level : sectionDto.getLevels()) {
			try {
				ResultLevel result = rs.getResultLevels()
						.get(level.getCodLevel());
				level.setComplete(result.isComplete());
				level.setUnlocked(result.isUnlocked());
				level.setNumAttemps(result.getNumAttemps());
				level.setNumCorrectQuestion(result.getNumCorrectQuestion());
				level.setNumIncorrectQuestion(result.getNumIncorrectQuestion());
				

				sectionDto.getLevels().add(level);
			} catch (Exception e) {

			}
		}

		return sectionDto;
	}
}
