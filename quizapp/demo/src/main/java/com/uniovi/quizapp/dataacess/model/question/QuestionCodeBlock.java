package com.uniovi.quizapp.dataacess.model.question;

public class QuestionCodeBlock extends Question {
	
	private String[] codeBlocksOptions;
	private String[] codeBlocksCorrect;
	
	public QuestionCodeBlock() {
		
	}
	
	public QuestionCodeBlock(String title, String statement) {
		super(title, statement, "codeBlock");
	}
	
	public String[] getCodeBlocksOptions() {
		return codeBlocksOptions;
	}
	public void setCodeBlocksOptions(String[] codeBlocksOptions) {
		this.codeBlocksOptions = codeBlocksOptions;
	}
	public String[] getCodeBlocksCorrect() {
		return codeBlocksCorrect;
	}
	public void setCodeBlocksCorrect(String[] codeBlocksCorrect) {
		this.codeBlocksCorrect = codeBlocksCorrect;
	}
	
	

}
