package com.uniovi.quizapp.logic.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.quizapp.dataacess.dao.api.ICustomQuestionDao;
import com.uniovi.quizapp.dataacess.model.question.CustomQuestion;
import com.uniovi.quizapp.dataacess.model.question.StateQuestion;
import com.uniovi.quizapp.logic.api.ICustomQuestionManagement;
import com.uniovi.quizapp.logic.general.AbstractManagement;
import com.uniovi.quizapp.service.dto.customQuestion.CustomQuestionDto;
import com.uniovi.quizapp.service.dto.customQuestion.ResponseQuestionDto;
import com.uniovi.quizapp.service.dto.customQuestion.VoteQuestionDto;

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
		List<CustomQuestion> questions = new ArrayList<>();
		
		if (Arrays.stream(numberForVote).anyMatch((x) -> x == cont%10)) {
			questions = questionDao.findQuestionForVote(username);
		} else {
			questions = questionDao.findQuestionForPlay(username);
		}
		
		Random rand = new Random();
	    int index = rand.nextInt(questions.size());
	    
	    Collections.shuffle(questions);
		
		dto = mapper.convertValue(questions.get(index), CustomQuestionDto.class);
		
		return dto;
	}

	@Override
	public void voteCustomQuestion(VoteQuestionDto dto) {
		this.questionDao.voteQuestion(new ObjectId(dto.getIdQuestion()), dto.isVote());
	}

	@Override
	public void responseCustomQuestion(ResponseQuestionDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	

}
