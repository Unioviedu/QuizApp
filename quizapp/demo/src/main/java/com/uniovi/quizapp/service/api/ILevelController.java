package com.uniovi.quizapp.service.api;

import com.uniovi.quizapp.service.dto.UserInfoDto;
import com.uniovi.quizapp.service.dto.level.ResultLevelDto;

public interface ILevelController {
	
	public UserInfoDto responseLevel(ResultLevelDto resultLevelDto);

}
