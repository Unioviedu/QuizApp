package com.uniovi.quizapp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.quizapp.logic.api.ICustomQuestionManagement;
import com.uniovi.quizapp.service.api.ICustomQuestionController;
import com.uniovi.quizapp.service.dto.CustomQuestionDto;

@RestController
public class CustomQuestionController implements ICustomQuestionController {
	
	@Autowired
	private ICustomQuestionManagement management;
	
	@RequestMapping("/newQuestion")
	@Override
	public void newQuestion(@RequestBody CustomQuestionDto dto) {
		this.management.newCustomQuestion(dto);
	}

}
