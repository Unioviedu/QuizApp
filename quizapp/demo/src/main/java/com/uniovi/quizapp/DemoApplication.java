package com.uniovi.quizapp;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class DemoApplication {
	
	@Autowired
	public Datastore datastore;
	
	@RequestMapping("/")
	String hello() {
		
		GenerateDB db = new GenerateDB();
		db.create();
		
		datastore.save(db.challanges);
		datastore.save(db.sections);
		datastore.save(db.user);
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
