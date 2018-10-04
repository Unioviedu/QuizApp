package com.uniovi.quizapp.logic.impl;

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
	
	@Autowired
	private ICustomQuestionDao questionDao;
	
	@Override
	public void newCustomQuestion(CustomQuestionDto dto) {
		CustomQuestion entity = mapper.convertValue(dto, CustomQuestion.class);
		entity.setState(StateQuestion.CREATED);
		
		this.questionDao.saveOrUpdate(entity);
	}
	
	

}
