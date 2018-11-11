package com.uniovi.quizapp.logic.api;

import com.uniovi.quizapp.service.dto.UserDto;

public interface IUserManagement {
	
	public UserDto getUser (String username);
	public UserDto registerNewUser (UserDto userDto);
	public boolean isCorrectUsername(String username);

}
