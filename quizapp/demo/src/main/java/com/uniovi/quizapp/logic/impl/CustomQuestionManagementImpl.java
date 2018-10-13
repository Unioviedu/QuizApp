package com.uniovi.quizapp.logic.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ICustomQuestionDao;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;
import com.uniovi.quizapp.dataacess.model.question.StateQuestion;
import com.uniovi.quizapp.logic.api.ICustomQuestionManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.service.dto.CustomQuestionDto;

@Service
public class CustomQuestionManagementImpl extends AbstractManagement implements ICustomQuestionManagement {
	private static int[] numberForVote = {0, 1, 2};
	@Autowired
	private ICustomQuestionDao questionDao;
	
	@Override
	public void newCustomQuestion(CustomQuestionDto dto) {
		CustomQuestion entity = mapper.convertValue(dto, CustomQuestion.class);
		entity.setState(StateQuestion.CREATED);
		
		this.questionDao.saveOrUpdate(entity);
	}

	@Override
	public CustomQuestionDto nextCustomQuestion(String username, int cont) {
		CustomQuestionDto dto = new CustomQuestionDto();
		CustomQuestion question;
		
		if (Arrays.stream(numberForVote).anyMatch((x) -> x == cont%10)) {
			question = questionForVote(username);
		} else {
			question = questionForPlay();
		}
		
		dto = mapper.convertValue(question, CustomQuestionDto.class);
		
		return dto;
	}
	
	private CustomQuestion questionForVote(String username) {
		return questionDao.findQuestionForVote(username);
	}
	
	private CustomQuestion questionForPlay() {
		return null;
	}
	
	

}
