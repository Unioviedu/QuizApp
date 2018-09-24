package com.uniovi.quizapp.service.api;

import com.uniovi.quizapp.service.dto.level.ResponseLevelDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

public interface ILevelController {
	
	public ResponseLevelDto responseLevel(ResultLevelDto resultLevelDto);

}
