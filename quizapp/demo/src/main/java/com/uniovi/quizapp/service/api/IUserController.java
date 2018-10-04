package com.uniovi.quizapp.service.api;

import com.uniovi.quizapp.service.dto.UserDto;

public interface IUserController {
	
	public UserDto getUser(String username);
	public UserDto register(UserDto userDto);

}
