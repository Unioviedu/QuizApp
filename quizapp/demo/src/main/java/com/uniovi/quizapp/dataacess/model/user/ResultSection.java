package com.uniovi.quizapp.dataacess.model.user;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.history.Section;

public class ResultSection {
	private ObjectId idSection;
	private boolean isUnlocked;
	private boolean isComplete;
	private boolean isCompleteAll;
	
	private Map<ObjectId, ResultLevel> resultLevels = new HashMap<>();
	private Set<ResultChallange> resultChallanges = new HashSet<>();
	
	public ResultSection() {}
	
	public ResultSection(Section section, List<Challange> challanges) {
		this.setIdSection(section.getId());
		
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
		section.getLevels().stream().forEach(level -> {
			ResultLevel rl = new ResultLevel(level);
			resultLevels.put(rl.getId(), rl);
		});
	}
	
	public boolean isUnlocked() {
		return isUnlocked;
	}
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
	
	public void addResultLevel(ResultLevel rl) {
		resultLevels.put(rl.getId(), rl);
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

	public ObjectId getIdSection() {
		return idSection;
	}

	public void setIdSection(ObjectId idSection) {
		this.idSection = idSection;
	}

	public Map<ObjectId, ResultLevel> getResultLevels() {
		return resultLevels;
	}

	public void setResultLevels(Map<ObjectId, ResultLevel> resultLevels) {
		this.resultLevels = resultLevels;
	}
	
	

}
