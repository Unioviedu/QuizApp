package com.uniovi.quizapp.dataacess.model.user;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.uniovi.quizapp.dataacess.model.Level;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.challange.Challange;

public class ResultSection {
	
	private String codSection;
	private boolean isUnlocked;
	private boolean isComplete;
	private boolean isCompleteAll;
	
	private Map<String, ResultLevel> resultLevels = new HashMap<>();
	private Set<ResultChallange> resultChallanges = new HashSet<>();
	
	public ResultSection() {}
	
	public ResultSection(Section section, List<Challange> challanges) {
		this.codSection = section.getCodSection();
		
		createLevels(section);
		createChallanges(challanges);
	}

	private void createChallanges(List<Challange> challanges) {
		Random r = new Random();
		int numberChallanges = r.nextInt(4)+1;
		List<Integer> challangesAdd = new ArrayList<>();
		
		for (int i = 0; i < numberChallanges; i++) {
			int newChallange = r.nextInt(challanges.size());
			
			while (challangesAdd.contains(newChallange)) {
				newChallange = r.nextInt(challanges.size());
			}
			
			ResultChallange rc = new ResultChallange(challanges.get(newChallange));
			
			challangesAdd.add(newChallange);
			resultChallanges.add(rc);
		}
		
	}

	private void createLevels(Section section) {
		for (Level level: section.getLevels()) {
			ResultLevel rl = new ResultLevel(level);
			
			resultLevels.put(rl.getCodLevel(), rl);
		}
	}
	
	
	public Map<String, ResultLevel> getResultLevels() {
		return resultLevels;
	}
	public void setResultLevels(Map<String, ResultLevel> resultLevels) {
		this.resultLevels = resultLevels;
	}
	public boolean isUnlocked() {
		return isUnlocked;
	}
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
	
	public void addResultLevel(ResultLevel rl) {
		resultLevels.put(rl.getCodLevel(), rl);
	}
	public String getCodSection() {
		return codSection;
	}
	public void setCodSection(String codSection) {
		this.codSection = codSection;
	}

	public Set<ResultChallange> getResultChallanges() {
		return resultChallanges;
	}

	public void setResultChallanges(Set<ResultChallange> resultChallanges) {
		this.resultChallanges = resultChallanges;
	}
	
	public void addChallanges (ResultChallange...challanges) {
		for (ResultChallange challange: challanges)
			this.resultChallanges.add(challange);
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isCompleteAll() {
		return isCompleteAll;
	}

	public void setCompleteAll(boolean isCompleteAll) {
		this.isCompleteAll = isCompleteAll;
	}
	
	

}
