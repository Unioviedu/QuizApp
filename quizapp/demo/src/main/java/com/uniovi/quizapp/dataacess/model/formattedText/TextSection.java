package com.uniovi.quizapp.dataacess.model.formattedText;

public class TextSection extends FormattedTextElement {
	
	private String content;
	
	public TextSection() {}
	
	public TextSection(String content) {
		this.type = FormattedText.TEXT_SECTION;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
