package com.uniovi.quizapp.dataacess.model.formattedText;

public class Separator extends FormattedTextElement {
	
	
	public Separator() {
		this.setType(FormattedText.SEPARATOR);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
