package com.uniovi.quizapp.dataacess.model.formattedText;

public class CodeSection extends FormattedTextElement {
	
	private String content;
	private String programmingLanguage;
	
	public CodeSection() {}
	
	public CodeSection(String content, String programmingLanguage) {
		this.type = FormattedText.CODE_SECTION;
		this.content = content;
		this.programmingLanguage = programmingLanguage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	
	

}
