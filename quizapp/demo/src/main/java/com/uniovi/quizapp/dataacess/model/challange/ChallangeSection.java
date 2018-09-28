package com.uniovi.quizapp.dataacess.model.challange;

public class ChallangeSection extends Challange {
	
	public ChallangeSection(int codChallange, String description) {
		super(codChallange, description);
		this.challageType = ChallangeType.SECTION;
	}
	
	public ChallangeSection() {
		
	}

}
