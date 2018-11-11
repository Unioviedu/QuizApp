package com.uniovi.quizapp.dataacess.model.formattedText;

public class Header extends FormattedTextElement {
	
	private String content;
	private int level;
	
	public Header() {}
	
	public Header(String content, int level) {
		this.type = FormattedText.HEADER;
		this.content = content;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
