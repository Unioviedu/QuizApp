package com.uniovi.quizapp.logic.general;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.bson.types.ObjectId;

import com.uniovi.quizapp.dataacess.model.user.ResultLevel;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;

public class ChallangeFunction {
	
	private HashMap<Integer, Function<ResultSection, Boolean>> functions = new HashMap<>();
	
	public static final int ALL_CORRECT_TO_FIRST = 1;
	private Function<ResultSection, Boolean> allCorrectToFirst;
	
	public static final int ALL_LEVELS_UNLOCK = 2;
	private Function<ResultSection, Boolean> allLevelsUnlock;
	
	public static final int ALL_LEVELS_ALL_CORRECT = 3;
	private Function<ResultSection, Boolean> allLevelsAllCorrect;
	
	public ChallangeFunction() {
		createFunctions();
	}
	
	public boolean checkChallange(int codChallange, ResultSection rs) {
		return functions.get(codChallange).apply(rs);
	}
	
	private void createFunctions() {
		allCorrectToFirst = result -> {
			for (Map.Entry<ObjectId, ResultLevel> level : result.getResultLevels().entrySet()) {
				ResultLevel resultLevel = level.getValue();
				if (resultLevel.getNumIncorrectQuestion() == 0 && resultLevel.getNumAttemps() == 1)
					return true;
			}
			
			return false;
		};
		
		allLevelsUnlock = result -> {
			for (Map.Entry<ObjectId, ResultLevel> level : result.getResultLevels().entrySet()) {
				ResultLevel resultLevel = level.getValue();
				if (!resultLevel.isUnlocked())
					return false;
			}
			
			return true;
		};
		
		allLevelsAllCorrect = result -> {
			for (Map.Entry<ObjectId, ResultLevel> level : result.getResultLevels().entrySet()) {
				ResultLevel resultLevel = level.getValue();
				if (!resultLevel.isComplete())
					return false;
			}
			
			return true;
		};
		
		functions.put(ALL_CORRECT_TO_FIRST, allCorrectToFirst);
		functions.put(ALL_LEVELS_UNLOCK, allLevelsUnlock);
		functions.put(ALL_LEVELS_ALL_CORRECT, allLevelsAllCorrect);
	}

}
