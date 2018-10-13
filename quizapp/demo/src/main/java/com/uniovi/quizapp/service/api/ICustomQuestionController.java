package com.uniovi.quizapp.service.api;

import com.uniovi.quizapp.service.dto.CustomQuestionDto;

public interface ICustomQuestionController {
	
	public void newQuestion(CustomQuestionDto dto);
	
	public CustomQuestionDto nextQuestion(String username, int contQuestion);

}
