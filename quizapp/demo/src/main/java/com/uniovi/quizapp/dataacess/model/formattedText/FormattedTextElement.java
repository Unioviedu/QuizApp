package com.uniovi.quizapp.dataacess.model.formattedText;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME, 
		property ="type", 
		include = JsonTypeInfo.As.PROPERTY,
		visible = true)
@JsonSubTypes({
	@JsonSubTypes.Type(value = Header.class, name = "header"),
	@JsonSubTypes.Type(value = CodeSection.class, name = "codeSection"),
	@JsonSubTypes.Type(value = TextSection.class, name = "textSection"),
	@JsonSubTypes.Type(value = Separator.class, name = "separator")
})
public abstract class FormattedTextElement {
	
	protected String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
