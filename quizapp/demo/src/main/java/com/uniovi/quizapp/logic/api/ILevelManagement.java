package com.uniovi.quizapp.logic.api;

import com.uniovi.quizapp.service.dto.UserInfoDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

public interface ILevelManagement {
	
	public UserInfoDto responseLevel(ResultLevelDto resultLevelDto);

}
