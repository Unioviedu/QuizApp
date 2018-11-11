package com.uniovi.quizapp.dataacess.model.formattedText;

import java.util.ArrayList;
import java.util.List;

public class FormattedText {
	
	public static String HEADER = "header",
						 TEXT_SECTION = "textSection",
						 CODE_SECTION = "codeSection",
						 SEPARATOR = "separator";
	
	public List<FormattedTextElement> blocks = new ArrayList<>();
	
	public FormattedText() {}
	
	public FormattedText(String simpleContent) {
		addTextSection(simpleContent);
	}
	
	public void addTextSection(String content) {
		blocks.add(new TextSection(content));
	}
	
	public void addCodeSection(String content, String programmingLanguague) {
		blocks.add(new CodeSection(content, programmingLanguague));
	}
	
	public void addHeader(String content, int level) {
		blocks.add(new Header(content, level));
	}
	
	public void addSeparator() {
		blocks.add(new Separator());
	}

}
