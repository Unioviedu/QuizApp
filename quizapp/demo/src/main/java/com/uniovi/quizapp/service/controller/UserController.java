package com.uniovi.quizapp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.quizapp.logic.api.IUserManagement;
import com.uniovi.quizapp.service.api.IUserController;
import com.uniovi.quizapp.service.dto.UserDto;

@RestController
public class UserController implements IUserController {
	
	@Autowired
	public IUserManagement userManagement;

	@Override
	@RequestMapping("/user")
	public UserDto getUser(@RequestParam("username") String username) {
		return userManagement.getUser(username);
	}
	
	

}
