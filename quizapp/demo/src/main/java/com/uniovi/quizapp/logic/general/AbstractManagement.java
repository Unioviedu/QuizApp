package com.uniovi.quizapp.logic.general;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractManagement {
	
	@Autowired
	public ObjectMapper mapper;

}
