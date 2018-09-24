package com.uniovi.quizapp.logic.api;

import com.uniovi.quizapp.service.dto.level.ResponseLevelDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

public interface ILevelManagement {
	
	public ResponseLevelDto responseLevel(ResultLevelDto resultLevelDto);

}
