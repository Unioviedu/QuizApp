package com.uniovi.quizapp.logic.api;

import com.uniovi.quizapp.service.dto.UserDto;

public interface IUserManagement {
	
	public UserDto getUser (String username);

}
