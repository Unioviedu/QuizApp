package com.uniovi.quizapp.dataacess.model.question;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.uniovi.quizapp.dataacess.model.general.DefaultEntity;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property ="className", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
	@JsonSubTypes.Type(value = QuestionOptions.class, name = "com.uniovi.quizapp.dataacess.model.question.QuestionOptions"),
	@JsonSubTypes.Type(value = QuestionCodeBlock.class, name = "com.uniovi.quizapp.dataacess.model.question.QuestionCodeBlock")
})
@Entity
public abstract class Question extends DefaultEntity {
	private String title;
	private String type;
	private String statement;
	
	public Question() {}

	public Question(String title, String statement, String type) {
		super();
		this.title = title;
		this.statement = statement;
		this.type = type;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
