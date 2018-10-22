package com.uniovi.quizapp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.quizapp.logic.api.ILevelManagement;
import com.uniovi.quizapp.service.api.ILevelController;
import com.uniovi.quizapp.service.dto.UserInfoDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

@RestController
public class LevelController implements ILevelController {
	
	@Autowired
	private ILevelManagement levelManagement;
	
	@RequestMapping("/responseLevel")
	public UserInfoDto responseLevel(@RequestBody ResultLevelDto rl) {
		return levelManagement.responseLevel(rl);
	}

}
