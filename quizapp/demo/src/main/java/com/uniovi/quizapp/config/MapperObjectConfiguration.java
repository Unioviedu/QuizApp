package com.uniovi.quizapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MapperObjectConfiguration {
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

}
