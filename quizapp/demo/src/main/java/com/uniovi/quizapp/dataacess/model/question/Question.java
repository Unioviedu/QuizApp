package com.uniovi.quizapp.dataacess.model.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME, 
		property ="type", 
		include = JsonTypeInfo.As.PROPERTY,
		visible = true)
@JsonSubTypes({
	@JsonSubTypes.Type(value = QuestionOptions.class, name = "option"),
	@JsonSubTypes.Type(value = QuestionCodeBlock.class, name = "codeBlock")
})
public abstract class Question {
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
