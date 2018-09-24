package com.uniovi.quizapp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.quizapp.logic.api.IUserManagement;

@RestController
public class UserController {
	
	@Autowired
	private IUserManagement userManagement;
	
	

}
