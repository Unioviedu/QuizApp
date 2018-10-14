package com.uniovi.quizapp.service.api;

import com.uniovi.quizapp.service.dto.customQuestion.CustomQuestionDto;
import com.uniovi.quizapp.service.dto.customQuestion.ResponseQuestionDto;
import com.uniovi.quizapp.service.dto.customQuestion.VoteQuestionDto;

public interface ICustomQuestionController {
	
	public void newQuestion(CustomQuestionDto dto);
	
	public CustomQuestionDto nextQuestion(String username, int contQuestion);
	
	public void voteQuestion(VoteQuestionDto dto);
	
	public void responseQuestion(ResponseQuestionDto dto);

}
